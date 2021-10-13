package tv.mapper.mapperbase.world;

import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;

public class BaseOreGenerator
{
    private static boolean generate;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void registerOreGen(BiomeLoadingEvent event)
    {
        for(CustomOre ore : OreList.ores)
        {
            if(ore.canGenerate())
            {
                String biome = event.getName().toString();

                if(ore.hasWhitelist())
                {
                    if(ore.getBiomeList().contains(biome))
                    {
                        generate = true;
                        if(ClientConfig.ENABLE_GEN_LOGS.get())
                            MapperBase.LOGGER.info(ore.name + " whitelisted for biome " + biome + " in the config.");
                    }
                    else
                        generate = false;
                }
                else
                {
                    if(ore.getBiomeList().contains(biome))
                    {
                        generate = false;
                        if(ClientConfig.ENABLE_GEN_LOGS.get())
                            MapperBase.LOGGER.info(ore.name + " blacklisted for biome " + biome + " in the config.");
                    }
                    else
                        generate = true;
                }

                if(generate)
                {
                    event.getGeneration().addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, ore.getFeature());
                }
            }
        }
    }
}