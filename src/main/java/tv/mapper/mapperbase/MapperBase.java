package tv.mapper.mapperbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(MapperBase.MODID)
public class MapperBase
{
    public static final String MODID = "mapperbase";
    public static final Logger LOGGER = LogManager.getLogger();

    public MapperBase()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Mapper Base setup started!");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {}

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {}
}