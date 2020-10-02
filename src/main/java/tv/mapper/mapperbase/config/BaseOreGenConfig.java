package tv.mapper.mapperbase.config;

import java.util.ArrayList;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.ConfigValue;

public class BaseOreGenConfig
{
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec COMMON_CONFIG;

    static
    {
        final Pair<CommonConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);

        COMMON = specPair.getLeft();
        COMMON_CONFIG = specPair.getRight();
    }

    public static class CommonConfig
    {
        public static ForgeConfigSpec.BooleanValue BITUMEN_GENERATION;
        public static ForgeConfigSpec.IntValue BITUMEN_CHANCE;
        public static ForgeConfigSpec.IntValue BITUMEN_SIZE;
        public static ForgeConfigSpec.IntValue BITUMEN_MIN_HEIGHT;
        public static ForgeConfigSpec.IntValue BITUMEN_MAX_HEIGHT;
        public static ForgeConfigSpec.BooleanValue BITUMEN_WHITELIST_MODE;
        public static ConfigValue<ArrayList<String>> BITUMEN_BIOME_LIST;

        private static ArrayList<String> default_biomes = new ArrayList<>();

        CommonConfig(ForgeConfigSpec.Builder COMMON_BUILDER)
        {
            // Nether biomes
            default_biomes.add("minecraft:nether_wastes");
            default_biomes.add("minecraft:soul_sand_valley");
            default_biomes.add("minecraft:basalt_deltas");
            default_biomes.add("minecraft:crimson_forest");
            default_biomes.add("minecraft:warped_forest");
            // End biomes
            default_biomes.add("minecraft:the_end");
            default_biomes.add("minecraft:end_barrens");
            default_biomes.add("minecraft:end_midlands");
            default_biomes.add("minecraft:end_highlands");
            default_biomes.add("minecraft:small_end_islands");
            default_biomes.add("minecraft:the_void");

            COMMON_BUILDER.comment("Bitumen Generation").push("bitumen");

            BITUMEN_GENERATION = COMMON_BUILDER.comment("Generate bitumen in the world [true / false]").define("bitumenGeneration", true);
            BITUMEN_SIZE = COMMON_BUILDER.comment("Size of bitumen pockets [1-100, default: 48]").defineInRange("bitumenSize", 48, 1, 100);
            BITUMEN_CHANCE = COMMON_BUILDER.comment("Amount of bitumen pocket being generated per chunk [1-100, default: 2]").defineInRange("bitumenChance", 2, 1, 100);
            BITUMEN_MIN_HEIGHT = COMMON_BUILDER.comment("Minimal height for bitumen pocket generation, [1-254, default: 56]").defineInRange("bitumenMinHeight", 56, 1, 254);
            BITUMEN_MAX_HEIGHT = COMMON_BUILDER.comment("Maximal height for bitumen pocket generation, must be higher than minimal height [1-255, default: 80]").defineInRange("bitumenMaxHeight", 80, 1, 255);

            COMMON_BUILDER.pop();
            COMMON_BUILDER.comment(
                "Biome Blacklist: list here the biomes you do not want bitumen ore to be generated in (syntax: \"modid:biome\". Examples: \"minecraft:plains\", \"biomesoplenty:meadow\"...). Note: you can replace the default values.").push(
                    "blacklist");

            BITUMEN_WHITELIST_MODE = COMMON_BUILDER.comment("Set to true to switch bitumen ore blacklist to whitelist mode [true / false, default: false]").define("bitumenWhitelist", false);
            BITUMEN_BIOME_LIST = COMMON_BUILDER.comment("List of blacklisted biomes for bitumen ore generation").define("bitumenBiomeBlacklist", default_biomes);

            COMMON_BUILDER.pop();
        }
    }
}