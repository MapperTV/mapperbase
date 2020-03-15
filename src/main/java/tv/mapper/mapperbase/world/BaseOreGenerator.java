package tv.mapper.mapperbase.world;

import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.CountRangeConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;

public class BaseOreGenerator
{
    public static void setupOregen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if(CommonConfig.BITUMEN_GENERATION.get())
                biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES,
                    Feature.ORE.withConfiguration(
                        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BaseBlocks.BITUMEN_ORE.get().getDefaultState(), CommonConfig.BITUMEN_SIZE.get().intValue())).withPlacement(
                            Placement.COUNT_RANGE.configure(
                                new CountRangeConfig(CommonConfig.BITUMEN_CHANCE.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MAX_HEIGHT.get()))));
        }
    }
}