package tv.mapper.mapperbase.api.data.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.mapperbase.MapperBase;

public class BaseTags
{
    public static class Items
    {
        public static final TagKey<Item> RODS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods"));
        public static final TagKey<Item> PLATES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates"));
        public static final TagKey<Item> FLATTER_HAMMERS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MapperBase.MODID, "flatter_hammers"));

        public static final TagKey<Item> INGOTS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/steel"));
        public static final TagKey<Item> NUGGETS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "nuggets/steel"));
        public static final TagKey<Item> STORAGE_BLOCKS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel"));
        public static final TagKey<Item> STORAGE_BLOCKS_RAW_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_steel"));
        public static final TagKey<Item> RODS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods/steel"));
        public static final TagKey<Item> PLATES_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates/steel"));

        public static final TagKey<Item> PLATES_IRON = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates/iron"));
        public static final TagKey<Item> RODS_IRON = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods/iron"));

        public static final TagKey<Item> AXES_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "axes/steel"));
        public static final TagKey<Item> PICKAXES_KEY = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "pickaxes/steel"));
        public static final TagKey<Item> SHOVELS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "shovels/steel"));
        public static final TagKey<Item> HOES_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "hoes/steel"));
        public static final TagKey<Item> SWORDS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "swords/steel"));
        public static final TagKey<Item> HELMETS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "helmets/steel"));
        public static final TagKey<Item> CHESTPLATE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "chestplates/steel"));
        public static final TagKey<Item> LEGGINGS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "leggings/steel"));
        public static final TagKey<Item> BOOTS_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "boots/steel"));
    }

    public static class Blocks
    {
        public static final TagKey<Block> NEEDS_STEEL_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "needs_steel_tool"));
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "incorrect_for_steel_tool"));

        public static final TagKey<Block> STORAGE_BLOCKS_STEEL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel"));
        public static final TagKey<Block> STORAGE_BLOCKS_RAW_STEEL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/raw_steel"));
    }
    
}
