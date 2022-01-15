package tv.mapper.mapperbase.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;

public class OreList
{
    public static List<CustomOre> ores = new ArrayList<>();

    public static void addOre(CustomOre ore)
    {
        ores.add(ore);
        if(ClientConfig.ENABLE_GEN_LOGS.get())
            MapperBase.LOGGER.debug("Registered ores: " + ores);
    }

    public static void addOre(Collection<? extends CustomOre> ore)
    {
        ores.addAll(ore);
        if(ClientConfig.ENABLE_GEN_LOGS.get())
            MapperBase.LOGGER.debug("Registered ores: " + ores);
    }
}