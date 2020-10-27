package tv.mapper.mapperbase.world;

import java.util.ArrayList;

import net.minecraft.world.gen.feature.ConfiguredFeature;

public class CustomOre
{
    public String name;

    private boolean allowGeneration;
    private boolean whitelisteMode;

    private ArrayList<String> biomeList;

    private ConfiguredFeature<?, ?> configuredFeature;

    public CustomOre(String name, ConfiguredFeature<?, ?> feature, boolean generate, boolean whitelist, ArrayList<String> list)
    {
        this.name = name;
        this.allowGeneration = generate;
        this.whitelisteMode = whitelist;
        this.biomeList = list;
        this.configuredFeature = feature;
    }

    public boolean canGenerate()
    {
        return this.allowGeneration;
    }

    public boolean hasWhitelist()
    {
        return this.whitelisteMode;
    }

    public ArrayList<String> getBiomeList()
    {
        return this.biomeList;
    }

    public ConfiguredFeature<?, ?> getFeature()
    {
        return this.configuredFeature;
    }
}
