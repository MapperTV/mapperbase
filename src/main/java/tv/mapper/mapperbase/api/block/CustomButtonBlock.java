package tv.mapper.mapperbase.api.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import tv.mapper.mapperbase.api.block.tools.ToolManager;
import tv.mapper.mapperbase.api.block.tools.ToolTiers;
import tv.mapper.mapperbase.api.block.tools.ToolTypes;

public class CustomButtonBlock extends ButtonBlock implements ToolManager
{
    private boolean wooden;
    protected ToolTiers tier;
    protected ToolTypes tool;

    public CustomButtonBlock(BlockSetType type, int ticksToStayPressed, Properties properties, ToolTypes tool)
    {
        super(type, ticksToStayPressed, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomButtonBlock(BlockSetType type, int ticksToStayPressed, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(type, ticksToStayPressed, properties);
        this.tool = tool;
        this.tier = tier;
    }

    @Override
    protected SoundEvent getSound(boolean activate)
    {
        if(wooden)
            return activate ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
        else
            return activate ? SoundEvents.STONE_BUTTON_CLICK_ON : SoundEvents.STONE_BUTTON_CLICK_OFF;
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
