package tv.mapper.mapperbase.data.tags;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import tv.mapper.mapperbase.MapperBase;

public class MB_Tags
{
    public static class Items
    {
        public static final TagKey<Item> RODS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods"));
        public static final TagKey<Item> PLATES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates"));
        public static final TagKey<Item> FLATTER_HAMMERS = ItemTags.create(ResourceLocation.fromNamespaceAndPath(MapperBase.MODID, "flatter_hammers"));

        public static final TagKey<Item> INGOT_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "ingots/steel"));
        public static final TagKey<Item> NUGGET_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "nuggets/steel"));
        public static final TagKey<Item> BLOCK_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel"));
        public static final TagKey<Item> ROD_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods/steel"));
        public static final TagKey<Item> PLATE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates/steel"));

        public static final TagKey<Item> PLATE_IRON = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "plates/iron"));
        public static final TagKey<Item> ROD_IRON = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "rods/iron"));

        public static final TagKey<Item> AXE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "axes/steel"));
        public static final TagKey<Item> PICKAXE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "pickaxes/steel"));
        public static final TagKey<Item> SHOVEL_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "shovels/steel"));
        public static final TagKey<Item> HOE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "hoes/steel"));
        public static final TagKey<Item> SWORD_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "swords/steel"));
        public static final TagKey<Item> HELMET_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "helmets/steel"));
        public static final TagKey<Item> CHESTPLATE_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "chestplates/steel"));
        public static final TagKey<Item> LEG_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "leggings/steel"));
        public static final TagKey<Item> FOOT_STEEL = ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", "boots/steel"));
    }

    public static class Blocks
    {
        public static final TagKey<Block> NEEDS_STEEL_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "needs_steel_tool"));
        public static final TagKey<Block> INCORRECT_FOR_STEEL_TOOL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "incorrect_for_steel_tool"));

        public static final TagKey<Block> STORAGE_BLOCK_STEEL = BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", "storage_blocks/steel"));
    }
}
