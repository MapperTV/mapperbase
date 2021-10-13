package tv.mapper.mapperbase.block;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.ButtonBlock;

public class CustomButtonBlock extends ButtonBlock
{
    private boolean wooden;

    public CustomButtonBlock(boolean isWooden, Properties properties)
    {
        super(isWooden, properties);
        this.wooden = isWooden;
    }

    @Override
    protected SoundEvent getSound(boolean activate)
    {
        if(wooden)
            return activate ? SoundEvents.WOODEN_BUTTON_CLICK_ON : SoundEvents.WOODEN_BUTTON_CLICK_OFF;
        else
            return activate ? SoundEvents.STONE_BUTTON_CLICK_ON : SoundEvents.STONE_BUTTON_CLICK_OFF;
    }
}