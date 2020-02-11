package tv.mapper.mapperbase.data.gen;

import net.minecraft.block.Block;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;

public class BaseBlockStates extends BlockStateProvider
{

    public BaseBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, MapperBase.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(BaseBlocks.STEEL_BLOCK);
        slabBlock((SlabBlock)BaseBlocks.STEEL_SLAB, modLoc("block/steel_block"), modLoc("block/steel_slab_side"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        stairsBlock((StairsBlock)BaseBlocks.STEEL_STAIRS, modLoc("block/steel_block"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        wallBlock((WallBlock)BaseBlocks.STEEL_WALL, modLoc("block/steel_block"));
        pressurePlateBlock(BaseBlocks.STEEL_PRESSURE_PLATE, new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate"),
            new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate_down"));
    }

    public void pressurePlateBlock(Block block, ModelFile plate, ModelFile plate_down)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.POWERED, true).modelForState().modelFile(plate_down).addModel().partialState().with(BlockStateProperties.POWERED,
            false).modelForState().modelFile(plate).addModel();
    }
}
