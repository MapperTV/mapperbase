package tv.mapper.mapperbase.world;

import net.minecraft.block.Blocks;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraft.world.gen.placement.TopSolidRangeConfig;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.BaseOreGenConfig.CommonConfig;

public class BaseOreGenerator
{
    private static boolean generate;
    private ConfiguredFeature<?, ?> oreGen;

    @SubscribeEvent(priority = EventPriority.HIGH)
    public void registerOreGen(BiomeLoadingEvent event)
    {
        String biome = event.getName().toString();

        if(CommonConfig.BITUMEN_WHITELIST_MODE.get())
        {
            if(CommonConfig.BITUMEN_BIOME_LIST.get().contains(biome))
            {
                generate = true;
                MapperBase.LOGGER.info("Bitumen ore whitelisted for biome " + biome + " in the config.");
            }
            else
                generate = false;
        }
        else
        {
            if(CommonConfig.BITUMEN_BIOME_LIST.get().contains(biome))
            {
                generate = false;
                MapperBase.LOGGER.info("Bitumen ore blacklisted for biome " + biome + " in the config.");
            }
            else
                generate = true;
        }

        if(generate)
        {
            if(oreGen == null)
                oreGen = Feature.ORE.withConfiguration(
                    new OreFeatureConfig(OreFeatureConfig.FillerBlockType.field_241882_a, Blocks.ACACIA_FENCE.getDefaultState(), CommonConfig.BITUMEN_SIZE.get())).withPlacement(
                        Placement.field_242907_l.configure(new TopSolidRangeConfig(CommonConfig.BITUMEN_MIN_HEIGHT.get(), 0, CommonConfig.BITUMEN_MAX_HEIGHT.get()))).func_242728_a().func_242731_b(
                            CommonConfig.BITUMEN_CHANCE.get());

            event.getGeneration().withFeature(GenerationStage.Decoration.UNDERGROUND_ORES, oreGen);
            MapperBase.LOGGER.debug("◘ Registering ore gen in biome " + event.getName());
        }
    }
}