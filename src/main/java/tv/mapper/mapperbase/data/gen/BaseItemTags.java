package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;

public class BaseItemTags extends ItemTagsProvider
{
    public BaseItemTags(DataGenerator generatorIn, BaseBlockTags blockTagProvider)
    {
        super(generatorIn, blockTagProvider);
    }

    public void registerTags()
    {
        func_240521_a_(BlockTags.STAIRS, ItemTags.STAIRS);
        func_240521_a_(BlockTags.SLABS, ItemTags.SLABS);
        func_240521_a_(BlockTags.WALLS, ItemTags.WALLS);
        func_240521_a_(BlockTags.FENCES, ItemTags.FENCES);
        func_240521_a_(Tags.Blocks.FENCES, Tags.Items.FENCES);
        func_240521_a_(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        func_240521_a_(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        func_240521_a_(Tags.Blocks.ORES, Tags.Items.ORES);
        func_240521_a_(BaseTags.ForgeBlocks.ORES_BITUMEN, BaseTags.ForgeItems.ORES_BITUMEN);
        func_240521_a_(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL, BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL);
        func_240521_a_(BaseTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN, BaseTags.ForgeItems.STORAGE_BLOCKS_BITUMEN);
        func_240521_a_(BaseTags.ForgeBlocks.PRESSURE_PLATES, BaseTags.ForgeItems.PRESSURE_PLATES);
        func_240521_a_(BaseTags.Blocks.CONCRETE, BaseTags.Items.CONCRETE);
        func_240521_a_(BaseTags.Blocks.ASPHALT, BaseTags.Items.ASPHALT);

        func_240522_a_(BaseTags.ForgeItems.INGOTS_STEEL).func_240532_a_(BaseItems.STEEL_INGOT.get());
        func_240522_a_(BaseTags.ForgeItems.NUGGETS_STEEL).func_240532_a_(BaseItems.STEEL_NUGGET.get());
        func_240522_a_(BaseTags.ForgeItems.PLATES_STEEL).func_240532_a_(BaseItems.STEEL_PLATE.get());
        func_240522_a_(BaseTags.ForgeItems.RODS_STEEL).func_240532_a_(BaseItems.STEEL_ROD.get());

        func_240522_a_(Tags.Items.NUGGETS).func_240532_a_(BaseItems.STEEL_NUGGET.get());
        func_240522_a_(Tags.Items.RODS).func_240532_a_(BaseItems.STEEL_ROD.get());
        func_240522_a_(Tags.Items.INGOTS).func_240532_a_(BaseItems.STEEL_INGOT.get());

        func_240522_a_(BaseTags.ForgeItems.PLATES_IRON).func_240532_a_(BaseItems.IRON_PLATE.get());
        func_240522_a_(BaseTags.ForgeItems.RODS_IRON).func_240532_a_(BaseItems.IRON_ROD.get());

        func_240522_a_(BaseTags.ForgeItems.PLATES).func_240532_a_(BaseItems.IRON_PLATE.get());
        func_240522_a_(BaseTags.ForgeItems.PLATES).func_240532_a_(BaseItems.STEEL_PLATE.get());

        func_240522_a_(ItemTags.field_232908_Z_).func_240532_a_(BaseItems.STEEL_INGOT.get());
    }
}