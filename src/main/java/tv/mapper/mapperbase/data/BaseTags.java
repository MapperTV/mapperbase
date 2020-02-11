package tv.mapper.mapperbase.data;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.util.ResourceLocation;

public class BaseTags
{
    public static class ForgeBlocks
    {
        public static final Tag<Block> PRESSURE_PLATES = tag("pressure_plates");

        public static final Tag<Block> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");

        private static Tag<Block> tag(String name)
        {
            return new BlockTags.Wrapper(new ResourceLocation("forge", name));
        }
    }

    public static class ForgeItems
    {

        public static final Tag<Item> PLATES = tag("plates");
        public static final Tag<Item> PLATES_IRON = tag("plates/iron");
        public static final Tag<Item> PLATES_STEEL = tag("plates/steel");

        public static final Tag<Item> RODS_IRON = tag("rods/iron");
        public static final Tag<Item> RODS_STEEL = tag("rods/steel");

        public static final Tag<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final Tag<Item> NUGGETS_STEEL = tag("nuggets/steel");
        public static final Tag<Item> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");

        public static final Tag<Item> PRESSURE_PLATES = tag("pressure_plates");

        private static Tag<Item> tag(String name)
        {
            return new ItemTags.Wrapper(new ResourceLocation("forge", name));
        }
    }
}