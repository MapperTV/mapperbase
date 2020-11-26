package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;

public class BaseItemTags extends ItemTagsProvider
{
    public BaseItemTags(DataGenerator generatorIn, BaseBlockTags blockTagProvider, ExistingFileHelper existingFileHelper)
    {
        super(generatorIn, blockTagProvider, MapperBase.MODID, existingFileHelper);
    }

    public void registerTags()
    {
        copy(BlockTags.STAIRS, ItemTags.STAIRS);
        copy(BlockTags.SLABS, ItemTags.SLABS);
        copy(BlockTags.WALLS, ItemTags.WALLS);
        copy(BlockTags.FENCES, ItemTags.FENCES);
        copy(Tags.Blocks.FENCES, Tags.Items.FENCES);
        copy(Tags.Blocks.FENCE_GATES, Tags.Items.FENCE_GATES);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(BaseTags.ForgeBlocks.ORES_BITUMEN, BaseTags.ForgeItems.ORES_BITUMEN);
        copy(BaseTags.ForgeBlocks.STORAGE_BLOCKS_STEEL, BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL);
        copy(BaseTags.ForgeBlocks.STORAGE_BLOCKS_BITUMEN, BaseTags.ForgeItems.STORAGE_BLOCKS_BITUMEN);
        copy(BaseTags.ForgeBlocks.PRESSURE_PLATES, BaseTags.ForgeItems.PRESSURE_PLATES);
        copy(BaseTags.Blocks.CONCRETE, BaseTags.Items.CONCRETE);
        copy(BaseTags.Blocks.ASPHALT, BaseTags.Items.ASPHALT);

        getOrCreateBuilder(BaseTags.ForgeItems.INGOTS_STEEL).add(BaseItems.STEEL_INGOT.get());
        getOrCreateBuilder(BaseTags.ForgeItems.NUGGETS_STEEL).add(BaseItems.STEEL_NUGGET.get());
        getOrCreateBuilder(BaseTags.ForgeItems.PLATES_STEEL).add(BaseItems.STEEL_PLATE.get());
        getOrCreateBuilder(BaseTags.ForgeItems.RODS_STEEL).add(BaseItems.STEEL_ROD.get());

        getOrCreateBuilder(Tags.Items.NUGGETS).add(BaseItems.STEEL_NUGGET.get());
        getOrCreateBuilder(Tags.Items.RODS).add(BaseItems.STEEL_ROD.get());
        getOrCreateBuilder(Tags.Items.INGOTS).add(BaseItems.STEEL_INGOT.get());

        getOrCreateBuilder(BaseTags.ForgeItems.PLATES_IRON).add(BaseItems.IRON_PLATE.get());
        getOrCreateBuilder(BaseTags.ForgeItems.RODS_IRON).add(BaseItems.IRON_ROD.get());

        getOrCreateBuilder(BaseTags.ForgeItems.PLATES).add(BaseItems.IRON_PLATE.get());
        getOrCreateBuilder(BaseTags.ForgeItems.PLATES).add(BaseItems.STEEL_PLATE.get());

        getOrCreateBuilder(ItemTags.BEACON_PAYMENT_ITEMS).add(BaseItems.STEEL_INGOT.get());

        getOrCreateBuilder(BaseTags.ForgeItems.BITUMEN).add(BaseItems.RAW_BITUMEN.get());
    }
}