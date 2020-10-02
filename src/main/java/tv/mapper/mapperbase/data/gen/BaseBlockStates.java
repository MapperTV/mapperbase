package tv.mapper.mapperbase.data.gen;

import java.util.function.Function;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.block.WallBlock;
import net.minecraft.block.WallHeight;
import net.minecraft.data.DataGenerator;
import net.minecraft.state.properties.AttachFace;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.state.properties.Half;
import net.minecraft.state.properties.StairsShape;
import net.minecraft.util.Direction;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.minecraftforge.client.model.generators.MultiPartBlockStateBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.UpDownBlock;

public class BaseBlockStates extends BlockStateProvider
{
    protected final String mod_id;

    public BaseBlockStates(DataGenerator gen, String modid, ExistingFileHelper exFileHelper)
    {
        super(gen, modid, exFileHelper);
        this.mod_id = modid;
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(BaseBlocks.STEEL_BLOCK.get());
        slabBlock((SlabBlock)BaseBlocks.STEEL_SLAB.get(), modLoc("block/steel_block"), modLoc("block/steel_slab_side"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        stairsBlock((StairsBlock)BaseBlocks.STEEL_STAIRS.get(), modLoc("block/steel_block"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        newWallBlock((WallBlock)BaseBlocks.STEEL_WALL.get(), new UncheckedModelFile(MapperBase.MODID + ":block/steel_wall_post"), new UncheckedModelFile(MapperBase.MODID + ":block/steel_wall_side"),
            new UncheckedModelFile(MapperBase.MODID + ":block/steel_wall_side_tall"));
        pressurePlateBlock(BaseBlocks.STEEL_PRESSURE_PLATE.get(), new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate"),
            new UncheckedModelFile(MapperBase.MODID + ":block/steel_pressure_plate_down"));
        fenceBlock((FenceBlock)BaseBlocks.STEEL_FENCE.get(), modLoc("block/steel_block"));
        fenceGateBlock(BaseBlocks.STEEL_FENCE_GATE.get(), modLoc("block/steel_block"));

        simpleBlock(BaseBlocks.CONCRETE.get());
        slabBlock((SlabBlock)BaseBlocks.CONCRETE_SLAB.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        stairsBlock((StairsBlock)BaseBlocks.CONCRETE_STAIRS.get(), modLoc("block/concrete"), modLoc("block/concrete"), modLoc("block/concrete"));
        newWallBlock((WallBlock)BaseBlocks.CONCRETE_WALL.get(), new UncheckedModelFile(MapperBase.MODID + ":block/concrete_wall_post"), new UncheckedModelFile(MapperBase.MODID + ":block/concrete_wall_side"),
            new UncheckedModelFile(MapperBase.MODID + ":block/concrete_wall_side_tall"));
        pressurePlateBlock(BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate"),
            new UncheckedModelFile(MapperBase.MODID + ":block/concrete_pressure_plate_down"));
        fenceBlock((FenceBlock)BaseBlocks.CONCRETE_FENCE.get(), modLoc("block/concrete"));
        fenceGateBlock(BaseBlocks.CONCRETE_FENCE_GATE.get(), modLoc("block/concrete"));

        simpleBlock(BaseBlocks.ASPHALT.get());
        slabBlock((SlabBlock)BaseBlocks.ASPHALT_SLAB.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        stairsBlock((StairsBlock)BaseBlocks.ASPHALT_STAIRS.get(), modLoc("block/asphalt"), modLoc("block/asphalt"), modLoc("block/asphalt"));
        pressurePlateBlock(BaseBlocks.ASPHALT_PRESSURE_PLATE.get(), new UncheckedModelFile(MapperBase.MODID + ":block/asphalt_pressure_plate"),
            new UncheckedModelFile(MapperBase.MODID + ":block/asphalt_pressure_plate_down"));

        simpleBlock(BaseBlocks.BITUMEN_ORE.get());
        simpleBlock(BaseBlocks.BITUMEN_BLOCK.get());

    }

    protected void pressurePlateBlock(Block block, ModelFile plate, ModelFile plate_down)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.POWERED, true).modelForState().modelFile(plate_down).addModel().partialState().with(BlockStateProperties.POWERED,
            false).modelForState().modelFile(plate).addModel();
    }

    protected void upDownBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(UpDownBlock.UPSIDE_DOWN, true).modelForState().modelFile(model).rotationX(180).addModel().partialState().with(UpDownBlock.UPSIDE_DOWN,
            false).modelForState().modelFile(model).addModel();
    }

    protected void allRotationBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.UP).modelForState().modelFile(model).rotationX(270).uvLock(true).addModel().partialState().with(
            BlockStateProperties.FACING, Direction.DOWN).modelForState().modelFile(model).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING,
                Direction.NORTH).modelForState().modelFile(model).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(
                    180).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).uvLock(true).addModel().partialState().with(
                        BlockStateProperties.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).uvLock(true).addModel();
    }

    protected void buttonBlock(Block block, ModelFile model, ModelFile pressed, int angleOffset)
    {
        getVariantBuilder(block).forAllStates(state ->
        {
            AttachFace face = state.get(BlockStateProperties.FACE);
            Direction dir = state.get(BlockStateProperties.HORIZONTAL_FACING);
            Boolean powered = state.get(BlockStateProperties.POWERED);

            return ConfiguredModel.builder().modelFile(powered ? pressed : model).rotationX(face == AttachFace.WALL ? 90 : face == AttachFace.CEILING ? 180 : 0).rotationY(
                (((int)dir.getHorizontalAngle()) + angleOffset) % 360).uvLock(face == AttachFace.WALL ? true : false).build();
        });
    }

    /**
     * Creates a blockstate file for blocks that have 4 orientations depeding of cardinal (north, south etc). e.g. chairs, suspended stairs...
     */
    protected void orientableBlock(Block block, ModelFile model, int angleOffset)
    {
        orientableBlock(block, $ -> model, angleOffset);
    }

    protected void orientableBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
    {
        getVariantBuilder(block).forAllStatesExcept(
            state -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationY(((int)state.get(BlockStateProperties.HORIZONTAL_FACING).getHorizontalAngle() + angleOffset) % 360).build(),
            BlockStateProperties.WATERLOGGED);
    }

    protected void rooftilesStairsBlock(StairsBlock block, ResourceLocation texture)
    {
        String baseName = block.getRegistryName().toString();
        ModelFile stairs = models().stairs(baseName, texture, texture, texture);
        ModelFile stairsInner = models().stairsInner(baseName + "_inner", texture, texture, texture);
        ModelFile stairsOuter = models().stairsOuter(baseName + "_outer", texture, texture, texture);

        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            Direction facing = state.get(StairsBlock.FACING);
            Half half = state.get(StairsBlock.HALF);
            StairsShape shape = state.get(StairsBlock.SHAPE);
            int yRot = (int)facing.rotateY().getHorizontalAngle(); // Stairs model is rotated 90 degrees clockwise for some reason
            if(shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT)
            {
                yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
            }
            if(shape != StairsShape.STRAIGHT && half == Half.TOP)
            {
                yRot += 90; // Top stairs are rotated 90 degrees clockwise
            }
            yRot %= 360;
            return ConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? stairsInner : stairsOuter).rotationX(
                half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(false).build();
        }, StairsBlock.WATERLOGGED);
    }

    protected void newWallBlock(WallBlock block, ModelFile post, ModelFile side, ModelFile side_tall)
    {
        MultiPartBlockStateBuilder builder = getMultipartBuilder(block);

        builder.part().modelFile(post).addModel().condition(WallBlock.UP, true).end();

        builder.part().modelFile(side).addModel().condition(WallBlock.WALL_HEIGHT_NORTH, WallHeight.LOW).end();
        builder.part().modelFile(side).rotationY(90).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_EAST, WallHeight.LOW).end();
        builder.part().modelFile(side).rotationY(180).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_SOUTH, WallHeight.LOW).end();
        builder.part().modelFile(side).rotationY(270).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_WEST, WallHeight.LOW).end();

        builder.part().modelFile(side_tall).addModel().condition(WallBlock.WALL_HEIGHT_NORTH, WallHeight.TALL).end();
        builder.part().modelFile(side_tall).rotationY(90).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_EAST, WallHeight.TALL).end();
        builder.part().modelFile(side_tall).rotationY(180).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_SOUTH, WallHeight.TALL).end();
        builder.part().modelFile(side_tall).rotationY(270).uvLock(true).addModel().condition(WallBlock.WALL_HEIGHT_WEST, WallHeight.TALL).end();
    }

    protected String getModId()
    {
        return this.mod_id;
    }
}