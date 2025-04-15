package tv.mapper.mapperbase.api.data.tags;

import java.util.concurrent.CompletableFuture;

import org.jetbrains.annotations.Nullable;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.api.block.tools.ToolManager;

public class BaseBlockTagsProvider extends BlockTagsProvider
{

    public BaseBlockTagsProvider(PackOutput output, CompletableFuture<Provider> lookupProvider, String modId, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, modId, existingFileHelper);
    }

    @Override
    protected void addTags(Provider provider)
    {}

    /**
     * Automatically registers tool tags from the provided block registry
     */
    protected void registerToolTags(DeferredRegister<Block> blocks)
    {
        for(DeferredHolder<Block, ? extends Block> object : blocks.getEntries())
        {
            Block block = object.get();

            if(block instanceof ToolManager)
            {
                switch(((ToolManager)block).getTool())
                {
                    case PICKAXE:
                        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(block);
                        break;
                    case AXE:
                        this.tag(BlockTags.MINEABLE_WITH_AXE).add(block);
                        break;
                    case SHOVEL:
                        this.tag(BlockTags.MINEABLE_WITH_SHOVEL).add(block);
                        break;
                    case HOE:
                        this.tag(BlockTags.MINEABLE_WITH_HOE).add(block);
                        break;
                    default:
                        break;
                }

                switch(((ToolManager)block).getTier())
                {
                    case WOOD:
                        this.tag(Tags.Blocks.NEEDS_WOOD_TOOL).add(block);
                        break;
                    case GOLD:
                        this.tag(Tags.Blocks.NEEDS_GOLD_TOOL).add(block);
                        break;
                    case STONE:
                        this.tag(BlockTags.NEEDS_STONE_TOOL).add(block);
                        break;
                    case IRON:
                        this.tag(BlockTags.NEEDS_IRON_TOOL).add(block);
                        break;
                    case STEEL:
                        this.tag(BaseTags.Blocks.NEEDS_STEEL_TOOL).add(block);
                        break;
                    case DIAMOND:
                        this.tag(BlockTags.NEEDS_DIAMOND_TOOL).add(block);
                        break;
                    case NETHERITE:
                        this.tag(Tags.Blocks.NEEDS_NETHERITE_TOOL).add(block);
                        break;
                    default:
                        break;
                }
            }
        }
    }

}
