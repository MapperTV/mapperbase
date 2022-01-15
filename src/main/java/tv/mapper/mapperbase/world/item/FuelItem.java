package tv.mapper.mapperbase.world.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeType;

public class FuelItem extends Item
{
    private int burnTime;

    public FuelItem(Properties builder, int burnTime)
    {
        super(builder);
        this.burnTime = burnTime;
    }

    @Override
    public int getBurnTime(ItemStack itemStack, RecipeType<?> recipeType)
    {
        return burnTime;
    }
}