package tv.mapper.mapperbase.block;

import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import tv.mapper.mapperbase.block.tools.ToolManager;
import tv.mapper.mapperbase.block.tools.ToolTiers;
import tv.mapper.mapperbase.block.tools.ToolTypes;

public class CustomPressurePlateBlock extends PressurePlateBlock implements ToolManager
{
    private ToolTiers tier;
    private ToolTypes tool;

    public CustomPressurePlateBlock(BlockSetType type, Properties properties, ToolTypes tool)
    {
        super(type, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomPressurePlateBlock(BlockSetType type, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(type, properties);
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
