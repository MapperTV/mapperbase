package tv.mapper.mapperbase;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.config.BaseConfig;
import tv.mapper.mapperbase.config.BaseOreGenConfig;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;
import tv.mapper.mapperbase.item.BaseItems;
import tv.mapper.mapperbase.util.ConfigChecker;
import tv.mapper.mapperbase.world.BaseOreGenerator;

@Mod(MapperBase.MODID)
public class MapperBase
{
    public static final String MODID = "mapperbase";
    public static final Logger LOGGER = LogManager.getLogger();

    public MapperBase()
    {
        ModLoadingContext.get().registerConfig(ModConfig.Type.CLIENT, BaseConfig.CLIENT_CONFIG);
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, BaseOreGenConfig.COMMON_CONFIG);

        BaseBlocks.init();
        BaseItems.init();

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::clientSetup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);

        MinecraftForge.EVENT_BUS.register(new BaseOreGenerator());
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Mapper Base setup started!");

        ConfigChecker.checkConfig();

        if(!CommonConfig.BITUMEN_GENERATION.get())
            LOGGER.info("Ore generation is disabled by config.");
    }

    private void clientSetup(final FMLClientSetupEvent event)
    {}

    private void serverSetup(final FMLDedicatedServerSetupEvent event)
    {}
}