package tv.mapper.mapperbase.data;

import net.minecraft.core.HolderLookup.Provider;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.api.data.loottable.BaseBlockLootSubProvider;
import tv.mapper.mapperbase.block.MB_Blocks;

public class LootTableGenerator extends BaseBlockLootSubProvider
{
    public LootTableGenerator(Provider provider, DeferredRegister.Blocks blockRegistry)
    {
        super(provider, blockRegistry);
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
        dropSelf(MB_Blocks.RAW_STEEL_BLOCK.get());

    }
}
