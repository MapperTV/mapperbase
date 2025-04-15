package tv.mapper.mapperbase.api.data.loottable;

import java.util.List;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

import com.google.common.collect.Sets;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.WritableRegistry;
import net.minecraft.data.PackOutput;
import net.minecraft.util.ProblemReporter;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.ValidationContext;

public class BaseLootTables extends BaseLootTableProvider
{
    private String modid;

    public BaseLootTables(PackOutput output, List<BaseLootTableProvider.SubProviderEntry> subProviders, CompletableFuture<Provider> registries, String name, String modid)
    {
        super(output, Set.of(), subProviders, registries, name);
        this.modid = modid;
    }

    @Override
    protected void validate(WritableRegistry<LootTable> writableregistry, ValidationContext validationcontext, ProblemReporter.Collector problemreporter$collector)
    {
        var modLootTablesId = BuiltInLootTables.all().stream().filter(id -> id.registry().getNamespace().equals(modid)).collect(Collectors.toSet());

        for(var id : Sets.difference(modLootTablesId, writableregistry.keySet()))
        {
            validationcontext.reportProblem("Missing built-in table: " + id);
        }

        writableregistry.forEach((lootTable -> lootTable.validate(validationcontext)));
    }
}
