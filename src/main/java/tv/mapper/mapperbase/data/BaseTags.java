package tv.mapper.mapperbase.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import tv.mapper.mapperbase.MapperBase;

public class BaseTags
{
    public static class Blocks
    {
        public static final ITag.INamedTag<Block> CONCRETE = tag("concrete");
        public static final ITag.INamedTag<Block> ASPHALT = tag("asphalt");

        private static ITag.INamedTag<Block> tag(String name)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation(MapperBase.MODID, name).toString());
        }
    }

    public static class Items
    {
        public static final ITag.INamedTag<Item> CONCRETE = tag("concrete");
        public static final ITag.INamedTag<Item> ASPHALT = tag("asphalt");

        private static ITag.INamedTag<Item> tag(String name)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation(MapperBase.MODID, name).toString());
        }
    }

    public static class ForgeBlocks
    {
        public static final ITag.INamedTag<Block> PRESSURE_PLATES = tag("pressure_plates");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");

        public static final ITag.INamedTag<Block> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final ITag.INamedTag<Block> ORES_BITUMEN = tag("ores/bitumen");

        private static ITag.INamedTag<Block> tag(String name)
        {
            return BlockTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }

    public static class ForgeItems
    {

        public static final ITag.INamedTag<Item> PLATES = tag("plates");
        public static final ITag.INamedTag<Item> PLATES_IRON = tag("plates/iron");
        public static final ITag.INamedTag<Item> PLATES_STEEL = tag("plates/steel");

        public static final ITag.INamedTag<Item> RODS_IRON = tag("rods/iron");
        public static final ITag.INamedTag<Item> RODS_STEEL = tag("rods/steel");

        public static final ITag.INamedTag<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final ITag.INamedTag<Item> NUGGETS_STEEL = tag("nuggets/steel");
        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");

        public static final ITag.INamedTag<Item> STORAGE_BLOCKS_BITUMEN = tag("storage_blocks/bitumen");
        public static final ITag.INamedTag<Item> ORES_BITUMEN = tag("ores/bitumen");

        public static final ITag.INamedTag<Item> PRESSURE_PLATES = tag("pressure_plates");

        private static ITag.INamedTag<Item> tag(String name)
        {
            return ItemTags.makeWrapperTag(new ResourceLocation("forge", name).toString());
        }
    }
}