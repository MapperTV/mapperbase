package tv.mapper.mapperbase.data.loot;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import net.neoforged.neoforge.common.loot.LootTableIdCondition;
import tv.mapper.mapperbase.item.MB_Items;

public class GlobalLootModifiersGenerator extends GlobalLootModifierProvider
{

    public GlobalLootModifiersGenerator(PackOutput output, CompletableFuture<Provider> registries, String modid)
    {
        super(output, registries, modid);
    }

    @Override
    protected void start()
    {
        add("steel_ingot_in_dungeon_chest", new MB_LootModifier(new LootItemCondition[] {LootTableIdCondition.builder(ResourceLocation.parse("chests/simple_dungeon")).build(), LootItemRandomChanceCondition.randomChance(0.15f).build()}, MB_Items.STEEL_INGOT.get()));
        add("steel_nugget_in_dungeon_chest", new MB_LootModifier(new LootItemCondition[] {LootTableIdCondition.builder(ResourceLocation.parse("chests/simple_dungeon")).build(), LootItemRandomChanceCondition.randomChance(0.4f).build()}, MB_Items.STEEL_NUGGET.get()));
        add("steel_horse_armor_in_dungeon_chest", new MB_LootModifier(new LootItemCondition[] {LootTableIdCondition.builder(ResourceLocation.parse("chests/simple_dungeon")).build(), LootItemRandomChanceCondition.randomChance(0.1f).build()}, MB_Items.STEEL_HORSE_ARMOR.get()));
    }

}
