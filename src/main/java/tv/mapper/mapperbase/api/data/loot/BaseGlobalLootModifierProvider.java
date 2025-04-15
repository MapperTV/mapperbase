package tv.mapper.mapperbase.api.data.loot;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;

public class BaseGlobalLootModifierProvider extends GlobalLootModifierProvider
{
    private String name;

    public BaseGlobalLootModifierProvider(PackOutput output, CompletableFuture<Provider> registries, String modid, String name)
    {
        super(output, registries, modid);
        this.name = name;
    }

    @Override
    protected void start()
    {}

    @Override
    public String getName()
    {
        return name;
    }

}
