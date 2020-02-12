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
        this.getBuilder(BlockTags.STAIRS).add(BaseBlocks.STEEL_STAIRS, BaseBlocks.CONCRETE_STAIRS);
        this.getBuilder(BlockTags.SLABS).add(BaseBlocks.STEEL_SLAB, BaseBlocks.CONCRETE_SLAB);
        this.getBuilder(BlockTags.WALLS).add(BaseBlocks.STEEL_WALL, BaseBlocks.CONCRETE_WALL);
        this.getBuilder(Tags.Blocks.STORAGE_BLOCKS).add(BaseBlocks.STEEL_BLOCK);
        this.getBuilder(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).add(BaseBlocks.STEEL_BLOCK);
        this.getBuilder(BaseTags.ForgeBlocks.PRESSURE_PLATES).add(BaseBlocks.STEEL_PRESSURE_PLATE, BaseBlocks.CONCRETE_PRESSURE_PLATE);
    }

}
