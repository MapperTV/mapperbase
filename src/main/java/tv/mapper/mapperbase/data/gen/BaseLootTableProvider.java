package tv.mapper.mapperbase.data.gen;

import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Stream;

import com.google.common.collect.ImmutableSet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.advancements.criterion.EnchantmentPredicate;
import net.minecraft.advancements.criterion.ItemPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.advancements.criterion.StatePropertiesPredicate;
import net.minecraft.block.BedBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SlabBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.DirectoryCache;
import net.minecraft.data.IDataProvider;
import net.minecraft.data.LootTableProvider;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.ConstantRange;
import net.minecraft.loot.ILootConditionConsumer;
import net.minecraft.loot.ILootFunctionConsumer;
import net.minecraft.loot.ItemLootEntry;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.RandomValueRange;
import net.minecraft.loot.StandaloneLootEntry;
import net.minecraft.loot.conditions.BlockStateProperty;
import net.minecraft.loot.conditions.ILootCondition;
import net.minecraft.loot.conditions.MatchTool;
import net.minecraft.loot.conditions.SurvivesExplosion;
import net.minecraft.loot.functions.ApplyBonus;
import net.minecraft.loot.functions.CopyName;
import net.minecraft.loot.functions.ExplosionDecay;
import net.minecraft.loot.functions.SetCount;
import net.minecraft.state.properties.BedPart;
import net.minecraft.state.properties.DoubleBlockHalf;
import net.minecraft.state.properties.SlabType;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.CustomDoorBlock;

public abstract class BaseLootTableProvider extends LootTableProvider
{

    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();

    protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();

    private static final Set<Item> IMMUNE_TO_EXPLOSIONS = Stream.of(Blocks.DRAGON_EGG, Blocks.BEACON, Blocks.CONDUIT, Blocks.SKELETON_SKULL, Blocks.WITHER_SKELETON_SKULL, Blocks.PLAYER_HEAD, Blocks.ZOMBIE_HEAD,
        Blocks.CREEPER_HEAD, Blocks.DRAGON_HEAD, Blocks.SHULKER_BOX, Blocks.BLACK_SHULKER_BOX, Blocks.BLUE_SHULKER_BOX, Blocks.BROWN_SHULKER_BOX, Blocks.CYAN_SHULKER_BOX, Blocks.GRAY_SHULKER_BOX,
        Blocks.GREEN_SHULKER_BOX, Blocks.LIGHT_BLUE_SHULKER_BOX, Blocks.LIGHT_GRAY_SHULKER_BOX, Blocks.LIME_SHULKER_BOX, Blocks.MAGENTA_SHULKER_BOX, Blocks.ORANGE_SHULKER_BOX, Blocks.PINK_SHULKER_BOX,
        Blocks.PURPLE_SHULKER_BOX, Blocks.RED_SHULKER_BOX, Blocks.WHITE_SHULKER_BOX, Blocks.YELLOW_SHULKER_BOX).map(IItemProvider::asItem).collect(ImmutableSet.toImmutableSet());

    private static final ILootCondition.IBuilder SILK_TOUCH = MatchTool.builder(ItemPredicate.Builder.create().enchantment(new EnchantmentPredicate(Enchantments.SILK_TOUCH, MinMaxBounds.IntBound.atLeast(1))));

    private final DataGenerator generator;

    public BaseLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
        this.generator = dataGeneratorIn;
    }

    protected abstract void addTables();

    protected static <T> T withExplosionDecay(IItemProvider p_218552_0_, ILootFunctionConsumer<T> p_218552_1_)
    {
        return (T)(!IMMUNE_TO_EXPLOSIONS.contains(p_218552_0_.asItem()) ? p_218552_1_.acceptFunction(ExplosionDecay.builder()) : p_218552_1_.cast());
    }

    protected static <T> T withSurvivesExplosion(IItemProvider p_218560_0_, ILootConditionConsumer<T> p_218560_1_)
    {
        return (T)(!IMMUNE_TO_EXPLOSIONS.contains(p_218560_0_.asItem()) ? p_218560_1_.acceptCondition(SurvivesExplosion.builder()) : p_218560_1_.cast());
    }

    protected LootTable.Builder createStandardTable(String modid, Block block)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(block)).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    protected LootTable.Builder createSlabTable(String modid, Block block)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(withExplosionDecay(block, ItemLootEntry.builder(block).acceptFunction(
            SetCount.builder(ConstantRange.of(2)).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(SlabBlock.TYPE, SlabType.DOUBLE))))));
        return LootTable.builder().addLootPool(builder);
    }

    protected LootTable.Builder createDoorTable(String modid, Block block)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(block).acceptCondition(
            BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(CustomDoorBlock.HALF, DoubleBlockHalf.LOWER)))).acceptCondition(SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    protected LootTable.Builder createBedTable(String modid, Block block)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(
            ItemLootEntry.builder(block).acceptCondition(BlockStateProperty.builder(block).fromProperties(StatePropertiesPredicate.Builder.newBuilder().withProp(BedBlock.PART, BedPart.HEAD)))).acceptCondition(
                SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    protected LootTable.Builder createChestTable(String name, Block block)
    {
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(ItemLootEntry.builder(block).acceptFunction(CopyName.builder(CopyName.Source.BLOCK_ENTITY))).acceptCondition(
            SurvivesExplosion.builder());
        return LootTable.builder().addLootPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Block loot)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(
            ((StandaloneLootEntry.Builder)ItemLootEntry.builder(block).acceptCondition(SILK_TOUCH)).alternatively(withSurvivesExplosion(block, ItemLootEntry.builder(loot))));
        return LootTable.builder().addLootPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Item loot)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(
            ((StandaloneLootEntry.Builder)ItemLootEntry.builder(block).acceptCondition(SILK_TOUCH)).alternatively(withSurvivesExplosion(block, ItemLootEntry.builder(loot))));
        return LootTable.builder().addLootPool(builder);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    protected LootTable.Builder createSilkTable(String modid, Block block, Item loot, int min, int max, int fortune)
    {
        String name = block.getRegistryName().toString().replace(modid + ":", "");
        LootPool.Builder builder = LootPool.builder().name(name).rolls(ConstantRange.of(1)).addEntry(
            ((StandaloneLootEntry.Builder)ItemLootEntry.builder(block).acceptCondition(SILK_TOUCH)).alternatively(withSurvivesExplosion(block,
                ItemLootEntry.builder(loot).acceptFunction(SetCount.builder(RandomValueRange.of(min, max))).acceptFunction(ApplyBonus.uniformBonusCount(Enchantments.FORTUNE, fortune)))));
        return LootTable.builder().addLootPool(builder);
    }

    @Override
    public void act(DirectoryCache cache)
    {
        addTables();

        Map<ResourceLocation, LootTable> tables = new HashMap<>();
        for(Map.Entry<Block, LootTable.Builder> entry : lootTables.entrySet())
        {
            tables.put(entry.getKey().getLootTable(), entry.getValue().setParameterSet(LootParameterSets.BLOCK).build());
        }
        writeTables(cache, tables);
    }

    private void writeTables(DirectoryCache cache, Map<ResourceLocation, LootTable> tables)
    {
        Path outputFolder = this.generator.getOutputFolder();
        tables.forEach((key, lootTable) ->
        {
            Path path = outputFolder.resolve("data/" + key.getNamespace() + "/loot_tables/" + key.getPath() + ".json");
            try
            {
                IDataProvider.save(GSON, cache, LootTableManager.toJson(lootTable), path);
            }
            catch(IOException e)
            {
                MapperBase.LOGGER.error("Couldn't write loot table {}", path, e);
            }
        });
    }

    @Override
    public String getName()
    {
        return "MapperBase LootTables";
    }
}