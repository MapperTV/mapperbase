package tv.mapper.mapperbase.util;

import java.util.ArrayList;

import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;

public class ConfigChecker
{
    public static void checkConfig()
    {
        // Check if config is correct
        ArrayList<String> biome_verify = new ArrayList<>();
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            biome_verify.add(biome.getRegistryName().toString());
        }

        for(String name : CommonConfig.BITUMEN_BIOME_LIST.get())
            if(!biome_verify.contains(name))
                MapperBase.LOGGER.warn("Invalid biome '" + name + "' in mapperbase-common.toml for bitumen ore black/whitelist, please check the entries!");
    }
}
