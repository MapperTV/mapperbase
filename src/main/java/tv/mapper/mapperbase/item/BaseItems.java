package tv.mapper.mapperbase.item;

import net.minecraft.item.AxeItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
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

    public static final Item STEEL_AXE = null;
    public static final Item STEEL_PICKAXE = null;
    public static final Item STEEL_SHOVEL = null;
    public static final Item STEEL_HOE = null;
    public static final Item STEEL_SWORD = null;

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

        event.getRegistry().register(new AxeItem(BaseItemTier.STEEL, 5.0F, -3.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)).setRegistryName("steel_axe"));
        event.getRegistry().register(new PickaxeItem(BaseItemTier.STEEL, 1, -2.8F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)).setRegistryName("steel_pickaxe"));
        event.getRegistry().register(new ShovelItem(BaseItemTier.STEEL, 1.5F, -3.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)).setRegistryName("steel_shovel"));
        event.getRegistry().register(new HoeItem(BaseItemTier.STEEL, 0.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)).setRegistryName("steel_hoe"));
        event.getRegistry().register(new SwordItem(BaseItemTier.STEEL, 3, -2.4F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)).setRegistryName("steel_sword"));
    }
}
