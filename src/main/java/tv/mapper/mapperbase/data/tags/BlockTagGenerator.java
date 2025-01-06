package tv.mapper.mapperbase.data.tags;

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
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.block.tools.ToolManager;

public class BlockTagGenerator extends BlockTagsProvider
{

    public BlockTagGenerator(PackOutput output, CompletableFuture<Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper)
    {
        super(output, lookupProvider, MapperBase.MODID, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
        // tag(BlockTags.MINEABLE_WITH_PICKAXE).add(MB_Blocks.STEEL_BLOCK.get(), MB_Blocks.STEEL_STAIRS.get(), MB_Blocks.STEEL_SLAB.get(), MB_Blocks.STEEL_WALL.get(),
        // MB_Blocks.STEEL_PRESSURE_PLATE.get(), MB_Blocks.STEEL_FENCE.get(), MB_Blocks.STEEL_FENCE_GATE.get());
        // tag(BlockTags.NEEDS_STONE_TOOL).add(MB_Blocks.STEEL_BLOCK.get(), MB_Blocks.STEEL_STAIRS.get(), MB_Blocks.STEEL_SLAB.get(), MB_Blocks.STEEL_WALL.get(), MB_Blocks.STEEL_PRESSURE_PLATE.get(),
        // MB_Blocks.STEEL_FENCE.get(), MB_Blocks.STEEL_FENCE_GATE.get());
        tag(MB_Tags.Blocks.STORAGE_BLOCK_STEEL).add(MB_Blocks.STEEL_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).add(MB_Blocks.STEEL_BLOCK.get());
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

    // Tool system
    protected void registerToolTags(DeferredRegister<Block> blocks)
    {
        for(DeferredHolder<Block, ? extends Block> object : MB_Blocks.BLOCKS.getEntries())
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
                        this.tag(MB_Tags.Blocks.NEEDS_STEEL_TOOL).add(block);
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
