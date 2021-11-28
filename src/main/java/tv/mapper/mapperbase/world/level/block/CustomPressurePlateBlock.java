package tv.mapper.mapperbase.world.level.block;

import net.minecraft.world.level.block.PressurePlateBlock;

public class CustomPressurePlateBlock extends PressurePlateBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties, ToolTypes tool)
    {
        super(sensitivity, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(sensitivity, properties);
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