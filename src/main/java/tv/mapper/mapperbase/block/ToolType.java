package tv.mapper.mapperbase.block;

public interface ToolType
{
    public ToolTiers tier = ToolTiers.WOOD;
    public ToolTypes tool = ToolTypes.NONE;

    public ToolTiers getTier();

    public ToolTypes getTool();
}