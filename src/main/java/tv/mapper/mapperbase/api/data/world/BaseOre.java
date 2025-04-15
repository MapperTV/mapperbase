package tv.mapper.mapperbase.api.data.world;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BaseOre
{
    public int minHeight;
    public int maxHeight;
    public int size;
    public int amount;
    public ResourceKey<ConfiguredFeature<?, ?>> configuredFeature;
    public ResourceKey<PlacedFeature> placedFeature;
    public ResourceKey<BiomeModifier> biomeModifier;
    public String name;
    public Block block;
    public Block deepBlock;
    public TagKey<Biome> biomeTag;

    /**
     * Defines a new underground feature (such as ore, rock pocket...). Takes a biome tag to define which biome it will be generated in.
     */
    
    public BaseOre(String name, String modid, Block block, Block deepBlock, TagKey<Biome> biomeTag, int minHeight, int maxHeight, int size, int amount)
    {
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.size = size > 64 ? 64 : size <= 0 ? 1 : size;
        this.amount = amount > 256 ? 256 : amount < 0 ? 0 : amount;
        this.configuredFeature = ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(modid, name));
        this.placedFeature = ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(modid, name));;
        this.biomeModifier = ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(modid, name));;
        this.name = name;
        this.block = block;
        this.deepBlock = deepBlock;
        this.biomeTag = biomeTag;
    }

}
