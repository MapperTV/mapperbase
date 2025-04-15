package tv.mapper.mapperbase.api.data.tags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BaseItemTagsProvider extends ItemTagsProvider
{
    public BaseItemTagsProvider(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modid, ExistingFileHelper existingFileHelper)
    {
        super(pOutput, pLookupProvider, pBlockTags, modid, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider)
    {}
}
