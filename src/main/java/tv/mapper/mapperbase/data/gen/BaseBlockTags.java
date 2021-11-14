package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fmllegacy.RegistryObject;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.block.ToolType;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseTiers;

public class BaseBlockTags extends BlockTagsProvider
{
    public BaseBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, MapperBase.MODID, existingFileHelper);
    }

    public void addTags()
    {
        this.tag(BlockTags.STAIRS).add(BaseBlocks.STEEL_STAIRS.get(), BaseBlocks.CONCRETE_STAIRS.get(), BaseBlocks.ASPHALT_STAIRS.get());
        this.tag(BlockTags.SLABS).add(BaseBlocks.STEEL_SLAB.get(), BaseBlocks.CONCRETE_SLAB.get(), BaseBlocks.ASPHALT_SLAB.get());
        this.tag(BlockTags.WALLS).add(BaseBlocks.STEEL_WALL.get(), BaseBlocks.CONCRETE_WALL.get());
        this.tag(BlockTags.FENCES).add(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.tag(Tags.Blocks.FENCE_GATES).add(BaseBlocks.STEEL_FENCE_GATE.get(), BaseBlocks.CONCRETE_FENCE_GATE.get());
        this.tag(Tags.Blocks.FENCES).add(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.tag(BaseTags.ForgeBlocks.FENCES_STEEL).add(BaseBlocks.STEEL_FENCE.get());
        this.tag(Tags.Blocks.STORAGE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get(), BaseBlocks.BITUMEN_BLOCK.get());
        this.tag(Tags.Blocks.ORES).add(BaseBlocks.BITUMEN_ORE.get());
        this.tag(BlockTags.BEACON_BASE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get());
        this.tag(BaseTags.ForgeBlocks.ORES_BITUMEN).add(BaseBlocks.BITUMEN_ORE.get());
        this.tag(BaseTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN).add(BaseBlocks.BITUMEN_BLOCK.get());
        this.tag(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).add(BaseBlocks.STEEL_BLOCK.get());
        this.tag(BaseTags.ForgeBlocks.PRESSURE_PLATES).add(BaseBlocks.STEEL_PRESSURE_PLATE.get(), BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), BaseBlocks.ASPHALT_PRESSURE_PLATE.get());
        this.tag(BaseTags.Blocks.CONCRETE).add(BaseBlocks.CONCRETE.get());
        this.tag(BaseTags.Blocks.ASPHALT).add(BaseBlocks.ASPHALT.get());

        // Tool system
        this.tag(BlockTags.MINEABLE_WITH_PICKAXE).add(BaseBlocks.STEEL_BLOCK.get(), BaseBlocks.STEEL_STAIRS.get(), BaseBlocks.STEEL_SLAB.get(), BaseBlocks.STEEL_WALL.get(), BaseBlocks.STEEL_FENCE.get(), BaseBlocks.STEEL_FENCE_GATE.get());
        this.tag(BlockTags.NEEDS_IRON_TOOL).add(BaseBlocks.STEEL_BLOCK.get(), BaseBlocks.STEEL_STAIRS.get(), BaseBlocks.STEEL_SLAB.get(), BaseBlocks.STEEL_WALL.get(), BaseBlocks.STEEL_FENCE.get(), BaseBlocks.STEEL_FENCE_GATE.get());

        for(RegistryObject<Block> object : BaseBlocks.BLOCKS.getEntries())
        {
            Block block = object.get();

            if(block instanceof ToolType)
            {
                switch(((ToolType)block).getTool())
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

                switch(((ToolType)block).getTier())
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
                        this.tag(BaseTiers.NEEDS_STEEL_TOOL).add(block);
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