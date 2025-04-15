package tv.mapper.mapperbase.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BiomeTags;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.api.data.world.BaseOre;
import tv.mapper.mapperbase.api.data.world.BaseWorldgenProvider;
import tv.mapper.mapperbase.block.MB_Blocks;

public class WorldGen extends BaseWorldgenProvider
{
    public WorldGen(PackOutput output, CompletableFuture<Provider> registries, String modid, String name)
    {
        super(output, registries, modid, name);
    }

    private static final BaseOre TEST_ORE = new BaseOre("test_ore", MapperBase.MODID, MB_Blocks.STEEL_FENCE.get(), MB_Blocks.STEEL_FENCE.get(), BiomeTags.IS_OVERWORLD, -48, 32, 5, 10);
    private static final BaseOre TEST_ORE_COLD = new BaseOre("test_ore_cold", MapperBase.MODID, MB_Blocks.STEEL_WALL.get(), MB_Blocks.STEEL_WALL.get(), BiomeTags.SPAWNS_SNOW_FOXES, 72, 300, 64, 5);

    public static void initOres()
    {
        addOre(TEST_ORE);
        addOre(TEST_ORE_COLD);
    }
}
