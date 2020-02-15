package tv.mapper.mapperbase.block;

import net.minecraft.block.Block;
import net.minecraft.block.FenceBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.item.BaseGroups;
import tv.mapper.mapperbase.util.RegistryUtils;

@ObjectHolder(MapperBase.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class BaseBlocks
{
    public static final Block STEEL_BLOCK = null;
    public static final Block STEEL_SLAB = null;
    public static final Block STEEL_STAIRS = null;
    public static final Block STEEL_WALL = null;
    public static final Block STEEL_PRESSURE_PLATE = null;
    public static final Block STEEL_FENCE = null;

    public static final Block CONCRETE = null;
    public static final Block CONCRETE_STAIRS = null;
    public static final Block CONCRETE_SLAB = null;
    public static final Block CONCRETE_WALL = null;
    public static final Block CONCRETE_PRESSURE_PLATE = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(
            new CustomBlock(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("steel_block"));
        RegistryUtils.createOnlyVariants(event, "steel", true, true, true, true, Material.IRON, MaterialColor.STONE, SoundType.LANTERN, ToolType.PICKAXE, 5.0F, 6.0F);
        event.getRegistry().register(
            new FenceBlock(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN)).setRegistryName("steel_fence"));

        event.getRegistry().register(
            new CustomBlock(Block.Properties.create(Material.ROCK, MaterialColor.STONE).hardnessAndResistance(1.5F, 6.0F).sound(SoundType.STONE), ToolType.PICKAXE).setRegistryName("concrete"));
        RegistryUtils.createOnlyVariants(event, "concrete", true, true, true, true, Material.ROCK, MaterialColor.STONE, SoundType.STONE, ToolType.PICKAXE, 1.5F, 6.0F);
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        RegistryUtils.createItemBlockWithVariants(event, BaseGroups.MAPPERBASE, STEEL_BLOCK, STEEL_STAIRS, STEEL_SLAB, STEEL_WALL, STEEL_PRESSURE_PLATE);
        event.getRegistry().register(new BlockItem(STEEL_FENCE, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_FENCE.getRegistryName()));
        RegistryUtils.createItemBlockWithVariants(event, BaseGroups.MAPPERBASE, CONCRETE, CONCRETE_STAIRS, CONCRETE_SLAB, CONCRETE_WALL, CONCRETE_PRESSURE_PLATE);
    }
}
