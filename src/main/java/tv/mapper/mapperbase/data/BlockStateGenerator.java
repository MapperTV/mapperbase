package tv.mapper.mapperbase.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.properties.Half;
import net.minecraft.world.level.block.state.properties.StairsShape;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ConfiguredModel;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;

public class BlockStateGenerator extends BlockStateProvider
{

    public BlockStateGenerator(PackOutput output, ExistingFileHelper exFileHelper)
    {
        super(output, MapperBase.MODID, exFileHelper);
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
    }

    /* Creates a stairs block with specific texture for the sides */
    public void texturedStairsBlock(StairBlock block, String name, ResourceLocation full, ResourceLocation side, ResourceLocation half)
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
}