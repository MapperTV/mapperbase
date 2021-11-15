package tv.mapper.mapperbase.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;

public class CustomButtonBlock extends ButtonBlock implements ToolType
{
    private boolean wooden;
    protected ToolTiers tier;
    protected ToolTypes tool;

    public CustomButtonBlock(boolean isWooden, Properties properties, ToolTypes tool)
    {
        super(isWooden, properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
    }

    public CustomButtonBlock(boolean isWooden, Properties properties, ToolTypes tool, ToolTiers tier)
    {
        super(isWooden, properties);
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