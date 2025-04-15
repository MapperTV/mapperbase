package tv.mapper.mapperbase.data;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.api.data.loottable.BaseLootTableProvider.SubProviderEntry;
import tv.mapper.mapperbase.api.data.loottable.BaseLootTables;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.data.loot.GlobalLootModifiersGenerator;
import tv.mapper.mapperbase.data.tags.BlockTagGenerator;
import tv.mapper.mapperbase.data.tags.ItemTagGenerator;

public class MB_DataGenerators
{
    public static void generate(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        PackOutput pack = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookup = event.getLookupProvider();

        generator.addProvider(event.includeClient(), new BlockStateGenerator(pack, MapperBase.MODID, event.getExistingFileHelper(), "Mapper Base Blockstates"));
        generator.addProvider(event.includeClient(), new BlockModelGenerator(pack, MapperBase.MODID, event.getExistingFileHelper(), "Mapper Base Block Models"));
        generator.addProvider(event.includeClient(), new ItemModelGenerator(pack, MapperBase.MODID, event.getExistingFileHelper(), "Mapper Basse Item Models"));
        generator.addProvider(event.includeClient(), new LangGenerator(pack, MapperBase.MODID, "en_us", "Mapper Base Lang US"));
        generator.addProvider(event.includeClient(), new LangGenerator(pack, MapperBase.MODID, "fr_fr", "Mapper Base Lang FR"));
        generator.addProvider(true, new BaseLootTables(pack, List.of(new SubProviderEntry(provider -> new LootTableGenerator(provider, MB_Blocks.BLOCKS), LootContextParamSets.BLOCK)), lookup, "Mapper Base Loot Tables", MapperBase.MODID));

        BlockTagGenerator blockTagProvider = new BlockTagGenerator(pack, lookup, MapperBase.MODID, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ItemTagGenerator(pack, lookup, blockTagProvider.contentsGetter(), MapperBase.MODID, event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new RecipeGenerator(pack, lookup, "Mapper Base Recipes"));

        generator.addProvider(event.includeServer(), new GlobalLootModifiersGenerator(pack, lookup, MapperBase.MODID, "Mapper Base Global Loot Modifiers"));

        // WorldGen.initOres();
        // generator.addProvider(event.includeServer(), new WorldGen(pack, lookup, MapperBase.MODID, "Mapper Base Worldgen"));
    }
}
