package tv.mapper.mapperbase.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class BaseGroups
{
    public static final ItemGroup MAPPERBASE = new ItemGroup("mapperbase_group")
    {
        @Override
        public ItemStack createIcon()
        {
            return new ItemStack(BaseItems.STEEL_INGOT);
        }
    };
}
