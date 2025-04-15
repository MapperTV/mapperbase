package tv.mapper.mapperbase.api.block;

import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import tv.mapper.mapperbase.api.block.tools.ToolManager;
import tv.mapper.mapperbase.api.block.tools.ToolTiers;
import tv.mapper.mapperbase.api.block.tools.ToolTypes;

public class CustomDoorBlock extends DoorBlock implements ToolManager
{
    protected ToolTiers tier;
    protected ToolTypes tool;

    public CustomDoorBlock(BlockSetType type, Properties properties, ToolTypes tool)
    {
        super(type, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomDoorBlock(BlockSetType type, Properties properties, ToolTypes tool, ToolTiers tier)
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
