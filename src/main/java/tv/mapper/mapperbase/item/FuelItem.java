package tv.mapper.mapperbase.item;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class FuelItem extends Item
{
    private int burnTime;

    public FuelItem(Properties builder, int burnTime)
    {
        super(builder);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemBlock)
    {
        return burnTime;
    }
}
