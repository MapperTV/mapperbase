package tv.mapper.mapperbase.data;

import java.util.stream.Collectors;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.packs.VanillaBlockLoot;
import net.minecraft.world.level.block.Block;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;

public class LootTableGenerator extends VanillaBlockLoot
{
    public LootTableGenerator(Provider p_344962_)
    {
        super(p_344962_);
    }

    @Override
    protected void generate()
    {
        dropSelf(MB_Blocks.STEEL_BLOCK.get());
        dropSelf(MB_Blocks.STEEL_STAIRS.get());
        add(MB_Blocks.STEEL_SLAB.get(), block -> this.createSlabItemTable(block));
        dropSelf(MB_Blocks.STEEL_WALL.get());
        dropSelf(MB_Blocks.STEEL_PRESSURE_PLATE.get());
        dropSelf(MB_Blocks.STEEL_FENCE.get());
        dropSelf(MB_Blocks.STEEL_FENCE_GATE.get());
        dropSelf(MB_Blocks.STEEL_BUTTON.get());

    }

    @Override
    protected Iterable<Block> getKnownBlocks()
    {
        return BuiltInRegistries.BLOCK.holders().filter(e -> e.key().location().getNamespace().equals(MapperBase.MODID)).map(Holder.Reference::value).collect(Collectors.toList());
    }
}
