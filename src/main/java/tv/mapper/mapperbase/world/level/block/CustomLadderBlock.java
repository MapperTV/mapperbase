package tv.mapper.mapperbase.world.level.block;

import net.minecraft.world.level.block.LadderBlock;

public class CustomLadderBlock extends LadderBlock implements ToolManager
{
    protected ToolTiers tier;
    protected ToolTypes tool;

    public CustomLadderBlock(Properties properties, ToolTypes tool)
    {
        super(properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomLadderBlock(Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(properties);
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