package tv.mapper.mapperbase.block;

import net.minecraft.block.AbstractButtonBlock;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;

public class CustomButtonBlock extends AbstractButtonBlock
{
    private boolean wooden;

    public CustomButtonBlock(boolean isWooden, Properties properties)
    {
        super(isWooden, properties);
        this.wooden = isWooden;
    }

    @Override
    protected SoundEvent getSoundEvent(boolean activate)
    {
        if(wooden)
            return activate ? SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_ON : SoundEvents.BLOCK_WOODEN_BUTTON_CLICK_OFF;
        else
            return activate ? SoundEvents.BLOCK_STONE_BUTTON_CLICK_ON : SoundEvents.BLOCK_STONE_BUTTON_CLICK_OFF;
    }
}