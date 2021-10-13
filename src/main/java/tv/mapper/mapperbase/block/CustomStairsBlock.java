package tv.mapper.mapperbase.block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CustomStairsBlock extends StairBlock
{
    public CustomStairsBlock(Supplier<BlockState> state, Properties properties)
    {
        super(state, properties);
    }
}