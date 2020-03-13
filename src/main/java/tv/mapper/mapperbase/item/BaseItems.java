package tv.mapper.mapperbase.item;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.AxeItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.HoeItem;
import net.minecraft.item.HorseArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ShovelItem;
import net.minecraft.item.SwordItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;

public class BaseItems
{
    private static final DeferredRegister<Item> ITEMS = new DeferredRegister<>(ForgeRegistries.ITEMS, MapperBase.MODID);

    public static final RegistryObject<Item> STEEL_ITEM = ITEMS.register("steel_block", () -> new BlockItem(BaseBlocks.STEEL_BLOCK.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_STAIRS_ITEM = ITEMS.register("steel_stairs", () -> new BlockItem(BaseBlocks.STEEL_STAIRS.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_SLAB_ITEM = ITEMS.register("steel_slab", () -> new BlockItem(BaseBlocks.STEEL_SLAB.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_WALL_ITEM = ITEMS.register("steel_wall", () -> new BlockItem(BaseBlocks.STEEL_WALL.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_PRESSURE_PLATE_ITEM = ITEMS.register("steel_pressure_plate",
        () -> new BlockItem(BaseBlocks.STEEL_PRESSURE_PLATE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_FENCE_ITEM = ITEMS.register("steel_fence", () -> new BlockItem(BaseBlocks.STEEL_FENCE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_FENCE_GATE_ITEM = ITEMS.register("steel_fence_gate",
        () -> new BlockItem(BaseBlocks.STEEL_FENCE_GATE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> CONCRETE_ITEM = ITEMS.register("concrete", () -> new BlockItem(BaseBlocks.CONCRETE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_STAIRS_ITEM = ITEMS.register("concrete_stairs", () -> new BlockItem(BaseBlocks.CONCRETE_STAIRS.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_SLAB_ITEM = ITEMS.register("concrete_slab", () -> new BlockItem(BaseBlocks.CONCRETE_SLAB.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_WALL_ITEM = ITEMS.register("concrete_wall", () -> new BlockItem(BaseBlocks.CONCRETE_WALL.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_PRESSURE_PLATE_ITEM = ITEMS.register("concrete_pressure_plate",
        () -> new BlockItem(BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_FENCE_ITEM = ITEMS.register("concrete_fence", () -> new BlockItem(BaseBlocks.CONCRETE_FENCE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> CONCRETE_FENCE_GATE_ITEM = ITEMS.register("concrete_fence_gate",
        () -> new BlockItem(BaseBlocks.CONCRETE_FENCE_GATE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> RAW_BITUMEN = ITEMS.register("raw_bitumen", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> BITUMEN_ITEM = ITEMS.register("bitumen_block", () -> new BlockItem(BaseBlocks.BITUMEN_BLOCK.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> ASPHALT_ITEM = ITEMS.register("asphalt", () -> new BlockItem(BaseBlocks.ASPHALT.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> ASPHALT_STAIRS_ITEM = ITEMS.register("asphalt_stairs", () -> new BlockItem(BaseBlocks.ASPHALT_STAIRS.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> ASPHALT_SLAB_ITEM = ITEMS.register("asphalt_slab", () -> new BlockItem(BaseBlocks.ASPHALT_SLAB.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> ASPHALT_PRESSURE_PLATE_ITEM = ITEMS.register("asphalt_pressure_plate",
        () -> new BlockItem(BaseBlocks.ASPHALT_PRESSURE_PLATE.get(), new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> STEEL_NUGGET = ITEMS.register("steel_nugget", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_INGOT = ITEMS.register("steel_ingot", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_PLATE = ITEMS.register("steel_plate", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_ROD = ITEMS.register("steel_rod", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> IRON_PLATE = ITEMS.register("iron_plate", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> IRON_ROD = ITEMS.register("iron_rod", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> BOLT = ITEMS.register("bolt", () -> new Item(new Item.Properties().group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<FlatterHammerItem> FLATTER_HAMMER = ITEMS.register("flatter_hammer", () -> new FlatterHammerItem(new Item.Properties().group(BaseGroups.MAPPERBASE).maxDamage(128)));

    public static final RegistryObject<Item> STEEL_AXE = ITEMS.register("steel_axe", () -> new AxeItem(BaseItemTier.STEEL, 5.0F, -3.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_PICKAXE = ITEMS.register("steel_pickaxe", () -> new PickaxeItem(BaseItemTier.STEEL, 1, -2.8F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_SHOVEL = ITEMS.register("steel_shovel", () -> new ShovelItem(BaseItemTier.STEEL, 1.5F, -3.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_HOE = ITEMS.register("steel_hoe", () -> new HoeItem(BaseItemTier.STEEL, 0.0F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_SWORD = ITEMS.register("steel_sword", () -> new SwordItem(BaseItemTier.STEEL, 3, -2.4F, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> STEEL_HELMET = ITEMS.register("steel_helmet",
        () -> new ArmorItem(BaseArmorMaterial.STEEL, EquipmentSlotType.HEAD, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_CHESTPLATE = ITEMS.register("steel_chestplate",
        () -> new ArmorItem(BaseArmorMaterial.STEEL, EquipmentSlotType.CHEST, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_LEGGINGS = ITEMS.register("steel_leggings",
        () -> new ArmorItem(BaseArmorMaterial.STEEL, EquipmentSlotType.LEGS, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));
    public static final RegistryObject<Item> STEEL_BOOTS = ITEMS.register("steel_boots",
        () -> new ArmorItem(BaseArmorMaterial.STEEL, EquipmentSlotType.FEET, (new Item.Properties()).group(BaseGroups.MAPPERBASE)));

    public static final RegistryObject<Item> STEEL_HORSE_ARMOR = ITEMS.register("steel_horse_armor",
        () -> new HorseArmorItem(9, new ResourceLocation(MapperBase.MODID, "textures/entity/horse/armor/horse_armor_steel.png"), (new Item.Properties()).maxStackSize(1).group(BaseGroups.MAPPERBASE)));

    public static void init()
    {
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}
