package tv.mapper.mapperbase.item;

import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.mapperbase.MapperBase;

@ObjectHolder(MapperBase.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class BaseItems
{
    public static final Item STEEL_INGOT = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("steel_ingot"));
    }
}
