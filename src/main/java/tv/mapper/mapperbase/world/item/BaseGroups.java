package tv.mapper.mapperbase.world.item;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class BaseGroups
{
    public static final CreativeModeTab MAPPERBASE = new CreativeModeTab("mapperbase_group")
    {
        @Override
        public ItemStack makeIcon()
        {
            return new ItemStack(BaseItems.STEEL_INGOT.get());
        }
    };
}