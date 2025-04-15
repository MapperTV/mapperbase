package tv.mapper.mapperbase.api.data;

import java.util.function.Function;

import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.neoforged.neoforge.client.model.generators.VariantBlockStateBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.block.SlopeBlock;
import tv.mapper.mapperbase.api.block.UpDownBlock;

public class BaseBlockStateProvider extends BlockStateProvider
{
    private String name;

    public BaseBlockStateProvider(PackOutput output, String modid, ExistingFileHelper exFileHelper, String name)
    {
        super(output, modid, exFileHelper);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    protected void registerStatesAndModels()
    {}

    /* Creates a stairs block with specific texture for the sides */
    protected void texturedStairsBlock(StairBlock block, String name, ResourceLocation full, ResourceLocation side, ResourceLocation half)
    {
        ModelFile stairs = models().withExistingParent(name, modLoc("textured_stairs")).texture("full", full).texture("side", side).texture("half", half);
        ModelFile stairsInner = models().withExistingParent(name + "_inner", modLoc("textured_stairs_inner")).texture("full", full).texture("side", side);
        ModelFile stairsOuter = models().withExistingParent(name + "_outer", modLoc("textured_stairs_outer")).texture("full", full).texture("side", side).texture("half", half);
        texturedStairsBlock(block, stairs, stairsInner, stairsOuter);
    }

    private void texturedStairsBlock(StairBlock block, ModelFile stairs, ModelFile stairsInner, ModelFile stairsOuter)
    {
        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            Direction facing = state.getValue(StairBlock.FACING);
            Half half = state.getValue(StairBlock.HALF);
            StairsShape shape = state.getValue(StairBlock.SHAPE);
            int yRot = (int)facing.getClockWise().toYRot(); // Stairs model is rotated 90 degrees clockwise for some reason
            if(shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT)
            {
                yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
            }
            if(shape != StairsShape.STRAIGHT && half == Half.TOP)
            {
                yRot += 90; // Top stairs are rotated 90 degrees clockwise
            }
            yRot %= 360;
            return ConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? stairsInner : stairsOuter).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).build();
        }, StairBlock.WATERLOGGED);
    }

    protected void upDownBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(UpDownBlock.UPSIDE_DOWN, true).modelForState().modelFile(model).rotationX(180).addModel().partialState().with(UpDownBlock.UPSIDE_DOWN, false).modelForState().modelFile(model).addModel();
    }

    protected void allRotationBlock(Block block, ModelFile model)
    {
        getVariantBuilder(block).partialState().with(BlockStateProperties.FACING, Direction.UP).modelForState().modelFile(model).rotationX(270).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.DOWN).modelForState().modelFile(model).rotationX(90).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.NORTH).modelForState().modelFile(model).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.SOUTH).modelForState().modelFile(model).rotationY(180).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.EAST).modelForState().modelFile(model).rotationY(90).uvLock(true).addModel().partialState().with(BlockStateProperties.FACING, Direction.WEST).modelForState().modelFile(model).rotationY(270).uvLock(true).addModel();
    }

    /**
     * Creates a blockstate file for blocks that have 4 orientations depending of cardinal (north, south etc). e.g. chairs, suspended stairs...
     */
    protected void orientableBlock(Block block, ModelFile model, int angleOffset)
    {
        orientableBlock(block, $ -> model, angleOffset);
    }

    protected void orientableBlock(Block block, Function<BlockState, ModelFile> modelFunc, int angleOffset)
    {
        getVariantBuilder(block).forAllStatesExcept(state -> ConfiguredModel.builder().modelFile(modelFunc.apply(state)).rotationY(((int)state.getValue(BlockStateProperties.HORIZONTAL_FACING).toYRot() + angleOffset) % 360).build(), BlockStateProperties.WATERLOGGED);
    }

    protected void rooftilesStairsBlock(StairBlock block, ResourceLocation texture)
    {
        String baseName = BuiltInRegistries.BLOCK.getKey(block).toString();
        ModelFile stairs = models().stairs(baseName, texture, texture, texture);
        ModelFile stairsInner = models().stairsInner(baseName + "_inner", texture, texture, texture);
        ModelFile stairsOuter = models().stairsOuter(baseName + "_outer", texture, texture, texture);

        getVariantBuilder(block).forAllStatesExcept(state ->
        {
            Direction facing = state.getValue(StairBlock.FACING);
            Half half = state.getValue(StairBlock.HALF);
            StairsShape shape = state.getValue(StairBlock.SHAPE);
            int yRot = (int)facing.getClockWise().toYRot(); // Stairs model is rotated 90 degrees clockwise for some reason
            if(shape == StairsShape.INNER_LEFT || shape == StairsShape.OUTER_LEFT)
            {
                yRot += 270; // Left facing stairs are rotated 90 degrees clockwise
            }
            if(shape != StairsShape.STRAIGHT && half == Half.TOP)
            {
                yRot += 90; // Top stairs are rotated 90 degrees clockwise
            }
            yRot %= 360;
            return ConfiguredModel.builder().modelFile(shape == StairsShape.STRAIGHT ? stairs : shape == StairsShape.INNER_LEFT || shape == StairsShape.INNER_RIGHT ? stairsInner : stairsOuter).rotationX(half == Half.BOTTOM ? 0 : 180).rotationY(yRot).uvLock(false).build();
        }, StairBlock.WATERLOGGED);
    }

    protected void slopeBlock(Block block, String name, String modid)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";
        for(int i = 1; i < 9; i++)
        {
            modelName = i == 8 ? modid + ":block/" + name : modid + ":block/" + name + "_slope_" + i * 2;
            builder.partialState().with(SlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).addModel();
        }
    }

    protected void slopeBlock(Block block, String name, String modid, Block fullBlock)
    {
        VariantBlockStateBuilder builder = getVariantBuilder(block);
        String modelName = "";
        for(int i = 1; i < 9; i++)
        {
            modelName = i == 8 ? fullBlock.getName() + ":block/" + fullBlock.getName() : modid + ":block/" + name + "_slope_" + i * 2;
            builder.partialState().with(SlopeBlock.LAYERS, i).modelForState().modelFile(new UncheckedModelFile(modelName)).addModel();
        }
    }

}
