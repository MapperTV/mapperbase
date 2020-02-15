package tv.mapper.mapperbase.data.gen;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.UpDownBlock;

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
        fenceBlock((FenceBlock)BaseBlocks.STEEL_FENCE, modLoc("block/steel_block"));

        simpleBlock(BaseBlocks.CONCRETE);
        slabBlock((SlabBlock)BaseBlocks.CONCRETE_SLAB, modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        stairsBlock((StairsBlock)BaseBlocks.CONCRETE_STAIRS, modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        wallBlock((WallBlock)BaseBlocks.CONCRETE_WALL, modLoc("block/concrete"));
        pressurePlateBlock(BaseBlocks.CONCRETE_PRESSURE_PLATE, new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate"),
            new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate_down"));
    }

    public void pressurePlateBlock(Block block, ModelFile plate, ModelFile plate_down)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.POWERED, true).modelForState().modelFile(plate_down).addModel().partialState().with(BlockStateProperties.POWERED,
            false).modelForState().modelFile(plate).addModel();
    }

    public void upDownBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(UpDownBlock.UPSIDE_DOWN, true).modelForState().modelFile(model).rotationX(180).addModel().partialState().with(UpDownBlock.UPSIDE_DOWN,
            false).modelForState().modelFile(model).addModel();
    }

    public void allRotationBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.UP).modelForState().modelFile(model).rotationX(270).uvLock(true).addModel().partialState().with(
            BlockStateProperties.FACING, Direction.DOWN).modelForState().modelFile(model).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING,
                Direction.NORTH).modelForState().modelFile(model).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(
                    180).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).uvLock(
                        true).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).uvLock(true).addModel();
    }
}
