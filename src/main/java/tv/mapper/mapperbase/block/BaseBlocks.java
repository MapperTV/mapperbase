package tv.mapper.mapperbase.block;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock.Sensitivity;
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

@ObjectHolder(MapperBase.MODID)
@EventBusSubscriber(bus = Bus.MOD)
public class BaseBlocks
{
    public static final Block STEEL_BLOCK = null;
    public static final Block STEEL_SLAB = null;
    public static final Block STEEL_STAIRS = null;
    public static final Block STEEL_WALL = null;
    public static final Block STEEL_PRESSURE_PLATE = null;

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        Block block;
        event.getRegistry().register(
            block = new Block(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN)).setRegistryName("steel_block"));
        event.getRegistry().register(
            new CustomSlabBlock(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName(
                "steel_slab"));
        event.getRegistry().register(new CustomStairsBlock(() -> block.getDefaultState(), Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(
            SoundType.LANTERN), ToolType.PICKAXE).setRegistryName("steel_stairs"));
        event.getRegistry().register(
            new CustomWallBlock(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN), ToolType.PICKAXE).setRegistryName(
                "steel_wall"));
        event.getRegistry().register(
            new CustomPressurePlateBlock(Sensitivity.MOBS, Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN)).setRegistryName(
                "steel_pressure_plate"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(STEEL_BLOCK, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_BLOCK.getRegistryName()));
        event.getRegistry().register(new BlockItem(STEEL_SLAB, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_SLAB.getRegistryName()));
        event.getRegistry().register(new BlockItem(STEEL_STAIRS, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_STAIRS.getRegistryName()));
        event.getRegistry().register(new BlockItem(STEEL_WALL, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_WALL.getRegistryName()));
        event.getRegistry().register(new BlockItem(STEEL_PRESSURE_PLATE, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_PRESSURE_PLATE.getRegistryName()));
    }
}
