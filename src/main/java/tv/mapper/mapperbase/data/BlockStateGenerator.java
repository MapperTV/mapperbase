package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.data.BaseBlockStateProvider;
import tv.mapper.mapperbase.block.MB_Blocks;

public class BlockStateGenerator extends BaseBlockStateProvider
{

    public BlockStateGenerator(PackOutput output, String modid, ExistingFileHelper exFileHelper, String name)
    {
        super(output, modid, exFileHelper, name);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(MB_Blocks.STEEL_BLOCK.get());
        texturedStairsBlock(MB_Blocks.STEEL_STAIRS.get(), "steel_stairs", modLoc("block/steel_block"), modLoc("block/steel_stairs"), modLoc("block/steel_slab_side"));
        slabBlock(MB_Blocks.STEEL_SLAB.get(), modLoc("block/steel_block"), modLoc("block/steel_slab_side"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        wallBlock(MB_Blocks.STEEL_WALL.get(), modLoc("block/steel_block"));
        pressurePlateBlock(MB_Blocks.STEEL_PRESSURE_PLATE.get(), modLoc("block/steel_block"));
        fenceBlock(MB_Blocks.STEEL_FENCE.get(), modLoc("block/steel_block"));
        fenceGateBlock(MB_Blocks.STEEL_FENCE_GATE.get(), modLoc("block/steel_block"));
        buttonBlock(MB_Blocks.STEEL_BUTTON.get(), modLoc("block/steel_block"));
        simpleBlock(MB_Blocks.RAW_STEEL_BLOCK.get());
    }
}
