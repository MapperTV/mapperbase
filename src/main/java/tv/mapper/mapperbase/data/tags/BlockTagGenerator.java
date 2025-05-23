package tv.mapper.mapperbase.data.tags;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.data.tags.BaseBlockTagsProvider;
import tv.mapper.mapperbase.api.data.tags.BaseTags;
import tv.mapper.mapperbase.block.MB_Blocks;

public class BlockTagGenerator extends BaseBlockTagsProvider
{

    public BlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider, String modid, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, modid, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
        tag(BaseTags.Blocks.STORAGE_BLOCKS_STEEL).add(MB_Blocks.STEEL_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).add(MB_Blocks.STEEL_BLOCK.get()).add(MB_Blocks.RAW_STEEL_BLOCK.get());
        tag(BaseTags.Blocks.STORAGE_BLOCKS_RAW_STEEL).add(MB_Blocks.RAW_STEEL_BLOCK.get());
        tag(BlockTags.BEACON_BASE_BLOCKS).add(MB_Blocks.STEEL_BLOCK.get());
        tag(BlockTags.STAIRS).add(MB_Blocks.STEEL_STAIRS.get());
        tag(BlockTags.SLABS).add(MB_Blocks.STEEL_SLAB.get());
        tag(BlockTags.WALLS).add(MB_Blocks.STEEL_WALL.get());
        tag(BlockTags.PRESSURE_PLATES).add(MB_Blocks.STEEL_PRESSURE_PLATE.get());
        tag(BlockTags.FENCES).add(MB_Blocks.STEEL_FENCE.get());
        tag(BlockTags.FENCE_GATES).add(MB_Blocks.STEEL_FENCE_GATE.get());
        tag(BlockTags.BUTTONS).add(MB_Blocks.STEEL_BUTTON.get());

        registerToolTags(MB_Blocks.BLOCKS);
    }
}
