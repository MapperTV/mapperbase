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
        this.func_240522_a_(BlockTags.STAIRS).func_240534_a_(BaseBlocks.STEEL_STAIRS.get(), BaseBlocks.CONCRETE_STAIRS.get(), BaseBlocks.ASPHALT_STAIRS.get());
        this.func_240522_a_(BlockTags.SLABS).func_240534_a_(BaseBlocks.STEEL_SLAB.get(), BaseBlocks.CONCRETE_SLAB.get(), BaseBlocks.ASPHALT_SLAB.get());
        this.func_240522_a_(BlockTags.WALLS).func_240534_a_(BaseBlocks.STEEL_WALL.get(), BaseBlocks.CONCRETE_WALL.get());
        this.func_240522_a_(BlockTags.FENCES).func_240534_a_(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.func_240522_a_(Tags.Blocks.FENCE_GATES).func_240534_a_(BaseBlocks.STEEL_FENCE_GATE.get(), BaseBlocks.CONCRETE_FENCE_GATE.get());
        this.func_240522_a_(Tags.Blocks.FENCES).func_240534_a_(BaseBlocks.STEEL_FENCE.get(), BaseBlocks.CONCRETE_FENCE.get());
        this.func_240522_a_(Tags.Blocks.STORAGE_BLOCKS).func_240534_a_(BaseBlocks.STEEL_BLOCK.get(), BaseBlocks.BITUMEN_BLOCK.get());
        this.func_240522_a_(Tags.Blocks.ORES).func_240532_a_(BaseBlocks.BITUMEN_ORE.get());
        this.func_240522_a_(BaseTags.ForgeBlocks.ORES_BITUMEN).func_240532_a_(BaseBlocks.BITUMEN_ORE.get());
        this.func_240522_a_(BaseTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN).func_240532_a_(BaseBlocks.BITUMEN_BLOCK.get());
        this.func_240522_a_(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL).func_240532_a_(BaseBlocks.STEEL_BLOCK.get());
        this.func_240522_a_(BaseTags.ForgeBlocks.PRESSURE_PLATES).func_240534_a_(BaseBlocks.STEEL_PRESSURE_PLATE.get(), BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), BaseBlocks.ASPHALT_PRESSURE_PLATE.get());
        this.func_240522_a_(BaseTags.Blocks.CONCRETE).func_240532_a_(BaseBlocks.CONCRETE.get());
        this.func_240522_a_(BaseTags.Blocks.ASPHALT).func_240532_a_(BaseBlocks.ASPHALT.get());
    }
}