package tv.mapper.mapperbase.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.BlockItemUseContext;
import net.minecraft.state.StateContainer;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.util.Direction;
import net.minecraftforge.common.ToolType;

public class AllRotationBlock extends CustomBlock
{
    public AllRotationBlock(Properties properties)
    {
        super(properties);
        this.setDefaultState(this.stateContainer.getBaseState().with(BlockStateProperties.FACING, Direction.NORTH));
    }

    public AllRotationBlock(Properties properties, ToolType toolType)
    {
        super(properties, toolType);
        this.setDefaultState(this.stateContainer.getBaseState().with(BlockStateProperties.FACING, Direction.NORTH));
    }

    @Override
    public BlockState getStateForPlacement(BlockItemUseContext context)
    {
        return this.getDefaultState().with(BlockStateProperties.FACING, context.getNearestLookingDirection().getOpposite());
    }

    @Override
    protected void fillStateContainer(StateContainer.Builder<Block, BlockState> builder)
    {
        builder.add(BlockStateProperties.FACING);
    }
}