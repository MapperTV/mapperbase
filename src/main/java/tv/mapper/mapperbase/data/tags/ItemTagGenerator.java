package tv.mapper.mapperbase.data.tags;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.data.tags.BaseItemTagsProvider;
import tv.mapper.mapperbase.api.data.tags.BaseTags;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.item.MB_Items;

public class ItemTagGenerator extends BaseItemTagsProvider
{

    public ItemTagGenerator(PackOutput pOutput, CompletableFuture<Provider> pLookupProvider, CompletableFuture<TagLookup<Block>> pBlockTags, String modid, ExistingFileHelper existingFileHelper)
    {
        super(pOutput, pLookupProvider, pBlockTags, modid, existingFileHelper);
    }

    @Override
    protected void addTags(Provider pProvider)
    {
        // Steel material
        tag(BaseTags.Items.INGOTS_STEEL).add(MB_Items.STEEL_INGOT.get());
        tag(Tags.Items.INGOTS).add(MB_Items.STEEL_INGOT.get());
        tag(ItemTags.BEACON_PAYMENT_ITEMS).add(MB_Items.STEEL_INGOT.get());
        tag(Tags.Items.NUGGETS).add(MB_Items.STEEL_NUGGET.get());
        tag(BaseTags.Items.NUGGETS_STEEL).add(MB_Items.STEEL_NUGGET.get());
        tag(BaseTags.Items.RODS_STEEL).add(MB_Items.STEEL_ROD.get());
        tag(BaseTags.Items.PLATES_STEEL).add(MB_Items.STEEL_PLATE.get());
        copy(BaseTags.Blocks.STORAGE_BLOCKS_STEEL, BaseTags.Items.BLOCKS_STEEL);
        tag(Tags.Items.STORAGE_BLOCKS).add(MB_Blocks.STEEL_BLOCK_ITEM.get());
        tag(ItemTags.STAIRS).add(MB_Blocks.STEEL_STAIRS_ITEM.get());
        tag(ItemTags.SLABS).add(MB_Blocks.STEEL_SLAB_ITEM.get());
        tag(ItemTags.WALLS).add(MB_Blocks.STEEL_WALL_ITEM.get());
        tag(ItemTags.FENCES).add(MB_Blocks.STEEL_FENCE_ITEM.get());
        tag(ItemTags.FENCE_GATES).add(MB_Blocks.STEEL_FENCE_GATE_ITEM.get());
        tag(ItemTags.BUTTONS).add(MB_Blocks.STEEL_BUTTON_ITEM.get());

        // Steel gear
        tag(ItemTags.SHARP_WEAPON_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_SWORD.get());
        tag(ItemTags.WEAPON_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_SWORD.get());
        tag(Tags.Items.ENCHANTABLES).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get(), MB_Items.STEEL_SWORD.get(), MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.AXES).add(MB_Items.STEEL_AXE.get());
        tag(ItemTags.BREAKS_DECORATED_POTS).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get(), MB_Items.STEEL_SWORD.get());
        tag(ItemTags.MINING_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get());
        tag(ItemTags.DURABILITY_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get(), MB_Items.STEEL_SWORD.get(), MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(Tags.Items.TOOLS).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get(), MB_Items.STEEL_SWORD.get());
        tag(ItemTags.MINING_LOOT_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get());
        tag(ItemTags.VANISHING_ENCHANTABLE).add(MB_Items.STEEL_AXE.get(), MB_Items.STEEL_PICKAXE.get(), MB_Items.STEEL_SHOVEL.get(), MB_Items.STEEL_HOE.get(), MB_Items.STEEL_SWORD.get(), MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.CLUSTER_MAX_HARVESTABLES).add(MB_Items.STEEL_PICKAXE.getKey());
        tag(ItemTags.PICKAXES).add(MB_Items.STEEL_PICKAXE.getKey());
        tag(ItemTags.SHOVELS).add(MB_Items.STEEL_SHOVEL.getKey());
        tag(ItemTags.HOES).add(MB_Items.STEEL_HOE.getKey());
        tag(ItemTags.SWORDS).add(MB_Items.STEEL_SWORD.getKey());
        tag(ItemTags.FIRE_ASPECT_ENCHANTABLE).add(MB_Items.STEEL_SWORD.getKey());
        tag(ItemTags.SWORD_ENCHANTABLE).add(MB_Items.STEEL_SWORD.getKey());
        tag(ItemTags.ARMOR_ENCHANTABLE).add(MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.EQUIPPABLE_ENCHANTABLE).add(MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.TRIMMABLE_ARMOR).add(MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE).add(MB_Items.STEEL_HELMET.get());
        tag(ItemTags.HEAD_ARMOR).add(MB_Items.STEEL_HELMET.get());
        tag(Tags.Items.ARMORS).add(MB_Items.STEEL_HELMET.get(), MB_Items.STEEL_CHESTPLATE.get(), MB_Items.STEEL_LEGGINGS.get(), MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.CHEST_ARMOR).add(MB_Items.STEEL_CHESTPLATE.get());
        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE).add(MB_Items.STEEL_CHESTPLATE.get());
        tag(ItemTags.LEG_ARMOR).add(MB_Items.STEEL_LEGGINGS.get());
        tag(ItemTags.LEG_ARMOR_ENCHANTABLE).add(MB_Items.STEEL_LEGGINGS.get());
        tag(ItemTags.FOOT_ARMOR).add(MB_Items.STEEL_BOOTS.get());
        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE).add(MB_Items.STEEL_BOOTS.get());

        tag(BaseTags.Items.AXES_STEEL).add(MB_Items.STEEL_AXE.getKey());
        tag(BaseTags.Items.PICKAXES_KEY).add(MB_Items.STEEL_PICKAXE.getKey());
        tag(BaseTags.Items.SHOVELS_STEEL).add(MB_Items.STEEL_SHOVEL.getKey());
        tag(BaseTags.Items.HOES_STEEL).add(MB_Items.STEEL_HOE.getKey());
        tag(BaseTags.Items.SWORDS_STEEL).add(MB_Items.STEEL_SWORD.getKey());
        tag(BaseTags.Items.HELMETS_STEEL).add(MB_Items.STEEL_HELMET.getKey());
        tag(BaseTags.Items.CHESTPLATE_STEEL).add(MB_Items.STEEL_CHESTPLATE.getKey());
        tag(BaseTags.Items.LEGGINGS_STEEL).add(MB_Items.STEEL_LEGGINGS.getKey());
        tag(BaseTags.Items.BOOTS_STEEL).add(MB_Items.STEEL_BOOTS.getKey());

        tag(BaseTags.Items.PLATES_IRON).add(MB_Items.IRON_PLATE.get());
        tag(BaseTags.Items.RODS_IRON).add(MB_Items.IRON_ROD.get());
        tag(BaseTags.Items.RODS).add(MB_Items.IRON_ROD.get()).add(MB_Items.STEEL_ROD.get());
        tag(BaseTags.Items.PLATES).add(MB_Items.STEEL_PLATE.get()).add(MB_Items.IRON_PLATE.get());
        tag(BaseTags.Items.FLATTER_HAMMERS).add(MB_Items.FLATTER_HAMMER.get()).add(MB_Items.REINFORCED_FLATTER_HAMMER.get());

    }

}
