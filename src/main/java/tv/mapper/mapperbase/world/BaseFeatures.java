package tv.mapper.mapperbase.world;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;

public class BaseFeatures
{
    public static ConfiguredFeature<?, ?> BITUMEN = Feature.ORE.withConfiguration(
        new OreFeatureConfig(OreFeatureConfig.FillerBlockType.BASE_STONE_OVERWORLD, BaseBlocks.BITUMEN_ORE.get().getDefaultState(), CommonConfig.BITUMEN_SIZE.get())).withPlacement(
            Placement.RANGE.configure(new TopSolidRangeConfig(CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MIN_HEIGHT.get(), CommonConfig.BITUMEN_MAX_HEIGHT.get()))).square().count(
                CommonConfig.BITUMEN_CHANCE.get());

    public static void registerFeatures()
    {
        Registry<ConfiguredFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_FEATURE;

        Registry.register(registry, new ResourceLocation(MapperBase.MODID, "bitumen_ore"), BITUMEN);

        if(ClientConfig.ENABLE_GEN_LOGS.get())
            MapperBase.LOGGER.debug("Registered feature " + BITUMEN.toString());
    }
}
