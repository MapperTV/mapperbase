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
    public static final Item STEEL_NUGGET = null;
    public static final Item STEEL_INGOT = null;
    public static final Item STEEL_PLATE = null;
    public static final Item STEEL_ROD = null;

    public static final Item IRON_PLATE = null;
    public static final Item IRON_ROD = null;

    public static final Item BOLT = null;

    public static final Item FLATTER_HAMMER = null;

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new FlatterHammerItem(new Item.Properties().group(BaseGroups.MAPPERBASE).maxDamage(128)).setRegistryName("flatter_hammer"));
        
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("steel_nugget"));
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("steel_ingot"));
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("steel_plate"));
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("steel_rod"));

        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("iron_plate"));
        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("iron_rod"));

        event.getRegistry().register(new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName("bolt"));
    }
}
