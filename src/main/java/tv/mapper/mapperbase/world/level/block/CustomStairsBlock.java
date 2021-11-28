package tv.mapper.mapperbase.world.level.block;

import java.util.function.Supplier;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CustomStairsBlock extends StairBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;
    
    public CustomStairsBlock(Supplier<BlockState> state, Properties properties, ToolTypes tool)
    {
        super(state, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomStairsBlock(Supplier<BlockState> state, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(state, properties);
        this.tool = tool;
        this.tier = tier;
    }

    @Override
    public ToolTiers getTier()
    {
        return this.tier;
    }

    @Override
    public ToolTypes getTool()
    {
        return this.tool;
    }
}