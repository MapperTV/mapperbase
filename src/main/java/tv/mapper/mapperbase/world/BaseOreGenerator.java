package tv.mapper.mapperbase.world;

import java.util.ArrayList;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;

public class BaseOreGenerator
{
    private static boolean generate;

    public static void setupOregen()
    {
        // Check if config is correct
        ArrayList<String> biome_verify = new ArrayList<>();
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            biome_verify.add(biome.getRegistryName().toString());
        }

        for(String name : CommonConfig.BITUMEN_BIOME_LIST.get())
        {
            if(!biome_verify.contains(name))
                MapperBase.LOGGER.warn("Invalid biome '" + name + "' in mapperbase-common.toml in bitumen ore blacklist, please verify the entries!");
        }

        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(CommonConfig.BITUMEN_GENERATION.get())
            {
                if(CommonConfig.BITUMEN_BIOME_LIST.get().contains(biome.getRegistryName().toString()))
                {
                    if(CommonConfig.BITUMEN_LIST_MODE.get())
                    {
                        MapperBase.LOGGER.info("Bitumen ore whitelisted for biome " + biome.getRegistryName() + " in the config.");
                        generate = true;
                    }
                    else
                    {
                        MapperBase.LOGGER.info("Bitumen ore blacklisted for biome " + biome.getRegistryName() + " in the config.");
                        generate = false;
                    }
                }
                else
                {
                    if(CommonConfig.BITUMEN_LIST_MODE.get())
                        generate = false;
                    else
                        generate = true;
                }

                if(generate)
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BaseBlocks.BITUMEN_ORE.get().getDefaultState(), CommonConfig.BITUMEN_SIZE.get().intValue())).withPlacement(
                            Placement.COUNT_RANGE.configure(
                                new CountRangeConfig(CommonConfig.BITUMEN_CHANCE.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MAX_HEIGHT.get()))));
            }
        }
    }
}