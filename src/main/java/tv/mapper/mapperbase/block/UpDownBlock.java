package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.StateContainer;
import net.minecraft.util.Direction;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.common.ToolType;

public class UpDownBlock extends CustomBlock
{
    public static final BooleanProperty UPSIDE_DOWN = BooleanProperty.create("upside_down");

    public UpDownBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.getDefaultState().with(UPSIDE_DOWN, Boolean.valueOf(false)));
    }

    public UpDownBlock(Properties properties, ToolType toolType)
    {
        super(properties, toolType);
        this.setDefaultState(this.getDefaultState().with(UPSIDE_DOWN, Boolean.valueOf(false)));
        this.toolType = toolType;
    }

    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(UPSIDE_DOWN);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        BlockPos blockpos = context.getPos();
        BlockState state = this.getDefaultState().with(UPSIDE_DOWN, false);
        Direction facing = context.getFace();
        return facing != Direction.DOWN && (facing == Direction.UP || !(context.getHitVec().y - (double)blockpos.getY() > 0.5D)) ? state : state.with(UPSIDE_DOWN, Boolean.valueOf(true));
    }
}