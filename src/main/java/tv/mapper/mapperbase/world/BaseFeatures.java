//package tv.mapper.mapperbase.world;
//
//public class BaseFeatures
//{
// public static final ConfiguredFeature<?, ?> ORE_BITUMEN = Feature.ORE.configured(new OreConfiguration(OreConfiguration.Predicates.NATURAL_STONE,
// BaseBlocks.BITUMEN_ORE.get().defaultBlockState(), CommonConfig.BITUMEN_SIZE.get())).rangeUniform(VerticalAnchor.absolute(CommonConfig.BITUMEN_MIN_HEIGHT.get()),
// VerticalAnchor.absolute(CommonConfig.BITUMEN_MAX_HEIGHT.get())).squared().count(CommonConfig.BITUMEN_CHANCE.get());
//
// public static void registerFeatures()
// {
// Registry<ConfiguredFeature<?, ?>> registry = BuiltinRegistries.CONFIGURED_FEATURE;
//
// Registry.register(registry, new ResourceLocation(MapperBase.MODID, "bitumen_ore"), ORE_BITUMEN);
//
// if(ClientConfig.ENABLE_GEN_LOGS.get())
// MapperBase.LOGGER.debug("Registered feature " + ORE_BITUMEN.toString());
// }
//}