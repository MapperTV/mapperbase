package tv.mapper.mapperbase.item;

import net.minecraft.world.item.AnimalArmorItem;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.SwordItem;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.MapperBase;

public class MB_Items
{
    // Registries
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(MapperBase.MODID);

    public static final DeferredItem<Item> STEEL_INGOT = ITEMS.registerSimpleItem("steel_ingot", new Item.Properties());
    public static final DeferredItem<Item> STEEL_NUGGET = ITEMS.registerSimpleItem("steel_nugget", new Item.Properties());
    public static final DeferredItem<Item> RAW_STEEL = ITEMS.registerSimpleItem("raw_steel", new Item.Properties());
    public static final DeferredItem<Item> PIG_IRON_CHUNK = ITEMS.registerSimpleItem("pig_iron_chunk", new Item.Properties());
    public static final DeferredItem<Item> STEEL_ROD = ITEMS.registerSimpleItem("steel_rod", new Item.Properties());
    public static final DeferredItem<Item> STEEL_PLATE = ITEMS.registerSimpleItem("steel_plate", new Item.Properties());

    public static final DeferredItem<Item> RIVET = ITEMS.registerSimpleItem("rivet", new Item.Properties());
    public static final DeferredItem<FlatterHammerItem> FLATTER_HAMMER = ITEMS.register("flatter_hammer", () -> new FlatterHammerItem(new Item.Properties().durability(127)));
    public static final DeferredItem<FlatterHammerItem> REINFORCED_FLATTER_HAMMER = ITEMS.register("reinforced_flatter_hammer", () -> new FlatterHammerItem(new Item.Properties().durability(511)));
    public static final DeferredItem<Item> IRON_PLATE = ITEMS.registerSimpleItem("iron_plate", new Item.Properties());
    public static final DeferredItem<Item> IRON_ROD = ITEMS.registerSimpleItem("iron_rod");

    // Steel tools
    public static final DeferredItem<SwordItem> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(MB_Tiers.STEEL_BASE_TIERS, new Item.Properties().attributes(SwordItem.createAttributes(MB_Tiers.STEEL_BASE_TIERS, 3, -2.4f))));
    public static final DeferredItem<AxeItem> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(MB_Tiers.STEEL_BASE_TIERS, new Item.Properties().attributes(AxeItem.createAttributes(MB_Tiers.STEEL_BASE_TIERS, 6f, -3f))));
    public static final DeferredItem<PickaxeItem> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(MB_Tiers.STEEL_BASE_TIERS, new Item.Properties().attributes(PickaxeItem.createAttributes(MB_Tiers.STEEL_BASE_TIERS, 1f, -2.8f))));
    public static final DeferredItem<ShovelItem> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(MB_Tiers.STEEL_BASE_TIERS, new Item.Properties().attributes(ShovelItem.createAttributes(MB_Tiers.STEEL_BASE_TIERS, 1.5f, -3f))));
    public static final DeferredItem<HoeItem> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(MB_Tiers.STEEL_BASE_TIERS, new Item.Properties().attributes(HoeItem.createAttributes(MB_Tiers.STEEL_BASE_TIERS, -2f, -1f))));

    public static final DeferredItem<ArmorItem> STEEL_HELMET = ITEMS.register("steel_helmet", () -> new ArmorItem(MB_Tiers.STEEL_ARMOR_MATERIAL, ArmorItem.Type.HELMET, new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(11))));
    public static final DeferredItem<ArmorItem> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate", () -> new ArmorItem(MB_Tiers.STEEL_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE, new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(16))));
    public static final DeferredItem<ArmorItem> STEEL_LEGGINGS = ITEMS.register("steel_leggings", () -> new ArmorItem(MB_Tiers.STEEL_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS, new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))));
    public static final DeferredItem<ArmorItem> STEEL_BOOTS = ITEMS.register("steel_boots", () -> new ArmorItem(MB_Tiers.STEEL_ARMOR_MATERIAL, ArmorItem.Type.BOOTS, new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(13))));

    public static final DeferredItem<Item> STEEL_HORSE_ARMOR = ITEMS.register("steel_horse_armor", () -> new AnimalArmorItem(MB_Tiers.STEEL_ARMOR_MATERIAL, AnimalArmorItem.BodyType.EQUESTRIAN, false, new Item.Properties().stacksTo(1)));
}
