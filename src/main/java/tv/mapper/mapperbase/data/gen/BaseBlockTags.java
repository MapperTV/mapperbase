package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.data.BaseTags;

public class BaseBlockTags extends BlockTagsProvider
{
    public BaseBlockTags(DataGenerator generatorIn, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, MapperBase.MODID, existingFileHelper);
    }

    public void registerTags()
    {
        this.getOrCreateBuilder(BlockTags.STAIRS).add(BaseBlocks.STEEL_STAIRS.get(), BaseBlocks.CONCRETE_STAIRS.get(), BaseBlocks.ASPHALT_STAIRS.get());
        this.getOrCreateBuilder(BlockTags.SLABS).add(BaseBlocks.STEEL_SLAB.get(), BaseBlocks.CONCRETE_SLAB.get(), BaseBlocks.ASPHALT_SLAB.get());
        this.getOrCreateBuilder(BlockTags.WALLS).add(BaseBlocks.STEEL_WALL.get(), BaseBlocks.CONCRETE_WALL.get());
        this.getOrCreateBuilder(BlockTags.FENCES).add(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.getOrCreateBuilder(Tags.Blocks.FENCE_GATES).add(BaseBlocks.STEEL_FENCE_GATE.get(), BaseBlocks.CONCRETE_FENCE_GATE.get());
        this.getOrCreateBuilder(Tags.Blocks.FENCES).add(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.getOrCreateBuilder(Tags.Blocks.STORAGE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get(), BaseBlocks.BITUMEN_BLOCK.get());
        this.getOrCreateBuilder(Tags.Blocks.ORES).addItemEntry(BaseBlocks.BITUMEN_ORE.get());
        this.getOrCreateBuilder(BlockTags.BEACON_BASE_BLOCKS).add(BaseBlocks.STEEL_BLOCK.get());
        this.getOrCreateBuilder(BaseTags.ForgeBlocks.ORES_BITUMEN).addItemEntry(BaseBlocks.BITUMEN_ORE.get());
        this.getOrCreateBuilder(BaseTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN).addItemEntry(BaseBlocks.BITUMEN_BLOCK.get());
        this.getOrCreateBuilder(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).addItemEntry(BaseBlocks.STEEL_BLOCK.get());
        this.getOrCreateBuilder(BaseTags.ForgeBlocks.PRESSURE_PLATES).add(BaseBlocks.STEEL_PRESSURE_PLATE.get(), BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), BaseBlocks.ASPHALT_PRESSURE_PLATE.get());
        this.getOrCreateBuilder(BaseTags.Blocks.CONCRETE).addItemEntry(BaseBlocks.CONCRETE.get());
        this.getOrCreateBuilder(BaseTags.Blocks.ASPHALT).addItemEntry(BaseBlocks.ASPHALT.get());
    }
}