package tv.mapper.mapperbase;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.config.MB_Config;
import tv.mapper.mapperbase.data.MB_DataGenerators;
import tv.mapper.mapperbase.item.MB_CreativeTab;
import tv.mapper.mapperbase.item.MB_Items;
import tv.mapper.mapperbase.item.MB_Tiers;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MapperBase.MODID)
public class MapperBase
{
    public static final String MODID = "mapperbase";
    private static final Logger LOGGER = LogUtils.getLogger();

    public MapperBase(IEventBus modEventBus, ModContainer modContainer)
    {
        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        MB_Blocks.BLOCKS.register(modEventBus);
        MB_Blocks.BLOCK_ITEMS.register(modEventBus);
        MB_Tiers.ARMOR_MATERIALS.register(modEventBus);
        MB_Items.ITEMS.register(modEventBus);

        MB_CreativeTab.CREATIVE_MODE_TABS.register(modEventBus);

        // NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        modEventBus.addListener(MB_DataGenerators::generate); // Data Generators
        modContainer.registerConfig(ModConfig.Type.COMMON, MB_Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        if(MB_Config.enableTagViewer)
            LOGGER.info("Tag Viewer enabled.");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES)
        {
            event.accept(MB_Items.STEEL_SHOVEL.get());
            event.accept(MB_Items.STEEL_PICKAXE.get());
            event.accept(MB_Items.STEEL_AXE.get());
            event.accept(MB_Items.STEEL_HOE.get());
        }
        if(event.getTabKey() == CreativeModeTabs.COMBAT)
        {
            event.accept(MB_Items.STEEL_SWORD.get());
            event.accept(MB_Items.STEEL_HELMET.get());
            event.accept(MB_Items.STEEL_CHESTPLATE.get());
            event.accept(MB_Items.STEEL_LEGGINGS.get());
            event.accept(MB_Items.STEEL_BOOTS.get());
        }
        if(event.getTabKey() == CreativeModeTabs.INGREDIENTS)
        {
            event.accept(MB_Items.PIG_IRON_CHUNK.get());
            event.accept(MB_Items.RAW_STEEL.get());
            event.accept(MB_Items.STEEL_INGOT.get());
            event.accept(MB_Items.STEEL_NUGGET.get());
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    // @SubscribeEvent
    // public void onServerStarting(ServerStartingEvent event)
    // {
    // Do something when the server starts
    // }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    // @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    // public static class ClientModEvents
    // {
    // @SubscribeEvent
    // public static void onClientSetup(FMLClientSetupEvent event)
    // {
    // Some client setup code
    // }
    // }
}
