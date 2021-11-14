package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class UpDownBlock extends CustomBlock
{
    public static final BooleanProperty UPSIDE_DOWN = BooleanProperty.create("upside_down");

    public UpDownBlock(Properties properties, ToolTypes tool)
    {
        super(properties, tool);
        this.registerDefaultState(this.defaultBlockState().setValue(UPSIDE_DOWN, Boolean.valueOf(false)));
    }

    public UpDownBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties, tool, tier);
        this.registerDefaultState(this.defaultBlockState().setValue(UPSIDE_DOWN, Boolean.valueOf(false)));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder)
    {
        builder.add(UPSIDE_DOWN);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context)
    {
        BlockPos blockpos = context.getClickedPos();
        BlockState state = this.defaultBlockState().setValue(UPSIDE_DOWN, false);
        Direction facing = context.getClickedFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getClickLocation().y - (double)blockpos.getY() > 0.5D)) ? state : state.setValue(UPSIDE_DOWN, Boolean.valueOf(true));
    }
}