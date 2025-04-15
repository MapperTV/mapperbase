package tv.mapper.mapperbase.api.block;

import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.state.BlockState;
import tv.mapper.mapperbase.api.block.tools.ToolManager;
import tv.mapper.mapperbase.api.block.tools.ToolTiers;
import tv.mapper.mapperbase.api.block.tools.ToolTypes;

public class CustomStairBlock extends StairBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomStairBlock(BlockState state, Properties properties, ToolTypes tool)
    {
        super(state, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomStairBlock(BlockState state, Properties properties, ToolTypes tool, ToolTiers tier)
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
