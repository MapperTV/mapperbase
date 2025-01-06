package tv.mapper.mapperbase.item;

import java.util.EnumMap;
import java.util.List;

import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.data.tags.MB_Tags;

public class MB_Tiers
{
    public static final DeferredRegister<ArmorMaterial> ARMOR_MATERIALS = DeferredRegister.create(BuiltInRegistries.ARMOR_MATERIAL, MapperBase.MODID);
    public static final Tier STEEL_BASE_TIERS = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL, 768, 7f, 2.5f, 8, () -> Ingredient.of(MB_Tags.Items.INGOT_STEEL));

    public static final Holder<ArmorMaterial> STEEL_ARMOR_MATERIAL = ARMOR_MATERIALS.register("steel", () -> new ArmorMaterial(Util.make(new EnumMap<>(ArmorItem.Type.class), map ->
    {
        map.put(ArmorItem.Type.BOOTS, 3);
        map.put(ArmorItem.Type.LEGGINGS, 5);
        map.put(ArmorItem.Type.CHESTPLATE, 7);
        map.put(ArmorItem.Type.HELMET, 2);
        map.put(ArmorItem.Type.BODY, 8);
    }), 9, SoundEvents.ARMOR_EQUIP_GENERIC, () -> Ingredient.of(MB_Tags.Items.INGOT_STEEL), List.of(new ArmorMaterial.Layer(ResourceLocation.fromNamespaceAndPath(MapperBase.MODID, "steel"))), 0, 0));
}
