package tv.mapper.mapperbase.data;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.neoforged.neoforge.data.event.GatherDataEvent;
import tv.mapper.mapperbase.MapperBase;
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

        generator.addProvider(event.includeClient(), new BlockStateGenerator(pack, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new BlockModelGenerator(pack, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new ItemModelGenerator(pack, event.getExistingFileHelper()));
        generator.addProvider(event.includeClient(), new LangGenerator(pack, MapperBase.MODID, "en_us"));
        generator.addProvider(event.includeClient(), new LangGenerator(pack, MapperBase.MODID, "fr_fr"));
        generator.addProvider(event.includeServer(), new LootTableProvider(pack, Collections.emptySet(), List.of(new LootTableProvider.SubProviderEntry(LootTableGenerator::new, LootContextParamSets.BLOCK)), lookup));

        BlockTagGenerator blockTagProvider = new BlockTagGenerator(pack, lookup, event.getExistingFileHelper());
        generator.addProvider(event.includeServer(), blockTagProvider);
        generator.addProvider(event.includeServer(), new ItemTagGenerator(pack, lookup, blockTagProvider.contentsGetter(), event.getExistingFileHelper()));

        generator.addProvider(event.includeServer(), new RecipeGenerator(pack, lookup));

        generator.addProvider(event.includeServer(), new GlobalLootModifiersGenerator(pack, lookup, MapperBase.MODID));

        // generator.addProvider(event.includeServer(), new WorldgenGenerator(pack, event.getLookupProvider()));
    }
}
