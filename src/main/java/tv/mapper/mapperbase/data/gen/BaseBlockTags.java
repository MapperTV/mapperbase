package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.data.BaseTags;

public class BaseBlockTags extends BlockTagsProvider
{

    public BaseBlockTags(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    public void registerTags()
    {
        this.getBuilder(BlockTags.STAIRS).add(BaseBlocks.STEEL_STAIRS);
        this.getBuilder(BlockTags.SLABS).add(BaseBlocks.STEEL_SLAB);
        this.getBuilder(BlockTags.WALLS).add(BaseBlocks.STEEL_WALL);
        this.getBuilder(Tags.Blocks.STORAGE_BLOCKS).add(BaseBlocks.STEEL_BLOCK);
        this.getBuilder(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).add(BaseBlocks.STEEL_BLOCK);
    }

}
