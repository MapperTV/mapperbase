package tv.mapper.mapperbase.data;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.mapperbase.MapperBase;

public class BaseTags
{
    public static class Blocks
    {
        @SuppressWarnings("unused")
        private static Tag.Named<Block> tag(String name)
        {
            return BlockTags.bind(new ResourceLocation(MapperBase.MODID, name).toString());
        }
    }

    public static class Items
    {
        @SuppressWarnings("unused")
        private static Tag.Named<Item> tag(String name)
        {
            return ItemTags.bind(new ResourceLocation(MapperBase.MODID, name).toString());
        }
    }

    public static class ForgeBlocks
    {
        public static final Tag.Named<Block> PRESSURE_PLATES = tag("pressure_plates");

        public static final Tag.Named<Block> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");
        public static final Tag.Named<Block> FENCES_STEEL = tag("fences/steel");

        private static Tag.Named<Block> tag(String name)
        {
            return BlockTags.bind(new ResourceLocation("forge", name).toString());
        }
    }

    public static class ForgeItems
    {

        public static final Tag.Named<Item> PLATES = tag("plates");
        public static final Tag.Named<Item> PLATES_IRON = tag("plates/iron");
        public static final Tag.Named<Item> PLATES_STEEL = tag("plates/steel");
        public static final Tag.Named<Item> FENCES_STEEL = tag("fences/steel");

        public static final Tag.Named<Item> RODS_IRON = tag("rods/iron");
        public static final Tag.Named<Item> RODS_STEEL = tag("rods/steel");

        public static final Tag.Named<Item> INGOTS_STEEL = tag("ingots/steel");
        public static final Tag.Named<Item> NUGGETS_STEEL = tag("nuggets/steel");
        public static final Tag.Named<Item> STORAGE_BLOCKS_STEEL = tag("storage_blocks/steel");

        public static final Tag.Named<Item> PRESSURE_PLATES = tag("pressure_plates");

        private static Tag.Named<Item> tag(String name)
        {
            return ItemTags.bind(new ResourceLocation("forge", name).toString());
        }
    }
}