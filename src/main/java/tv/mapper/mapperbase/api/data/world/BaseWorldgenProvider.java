package tv.mapper.mapperbase.api.data.world;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.HolderSet;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BaseWorldgenProvider extends DatapackBuiltinEntriesProvider
{
    public static List<BaseOre> ores = new ArrayList<>();
    private String name;

    public BaseWorldgenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries, String modid, String name)
    {
        super(output, registries, new RegistrySetBuilder().add(Registries.CONFIGURED_FEATURE, BaseConfiguredFeatures::defineConfiguredFeatures).add(Registries.PLACED_FEATURE, BasePlacedFeatures::definePlacedFeatures).add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, BaseBiomeModifiers::defineBiomeModifiers), Set.of(modid));
        this.name = name;
    }

    public static void addOre(BaseOre ore)
    {
        ores.add(ore);
    }

    public static void addOre(Collection<? extends BaseOre> ore)
    {
        ores.addAll(ore);
    }

    public class BaseBiomeModifiers
    {
        public static void defineBiomeModifiers(BootstrapContext<BiomeModifier> context)
        {
            HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
            HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

            for(BaseOre ore : ores)
            {
                context.register(ore.biomeModifier, new BiomeModifiers.AddFeaturesBiomeModifier(biomes.getOrThrow(ore.biomeTag), HolderSet.direct(placedFeatures.getOrThrow(ore.placedFeature)), GenerationStep.Decoration.UNDERGROUND_ORES));
            }
        }
    }

    public class BaseConfiguredFeatures
    {
        public static void defineConfiguredFeatures(BootstrapContext<ConfiguredFeature<?, ?>> context)
        {
            RuleTest stoneReplacable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
            RuleTest deepslateReplacable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

            for(BaseOre ore : ores)
            {
                context.register(ore.configuredFeature, new ConfiguredFeature<>(Feature.ORE, new OreConfiguration(List.of(OreConfiguration.target(stoneReplacable, ore.block.defaultBlockState()), OreConfiguration.target(deepslateReplacable, ore.deepBlock.defaultBlockState())), ore.size)));

            }
        }
    }

    public class BasePlacedFeatures
    {
        public static void definePlacedFeatures(BootstrapContext<PlacedFeature> context)
        {
            HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

            for(BaseOre ore : ores)
            {
                context.register(ore.placedFeature, new PlacedFeature(configuredFeatures.getOrThrow(ore.configuredFeature), BaseWorldgenProvider.commonOrePlacements(ore.amount, HeightRangePlacement.uniform(VerticalAnchor.absolute(ore.minHeight), VerticalAnchor.absolute(ore.maxHeight)))));
            }
        }
    }

    private static List<PlacementModifier> orePlacements(PlacementModifier placementModifier, PlacementModifier placementModifier1)
    {
        return List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacements(int count, PlacementModifier placementModifier)
    {
        return orePlacements(CountPlacement.of(count), placementModifier);
    }

    public static List<PlacementModifier> rareOrePlacements(int count, PlacementModifier placementModifier)
    {
        return orePlacements(RarityFilter.onAverageOnceEvery(count), placementModifier);
    }

    @Override
    public String getName()
    {
        return name;
    }
}
