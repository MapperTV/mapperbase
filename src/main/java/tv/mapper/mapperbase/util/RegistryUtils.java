package tv.mapper.mapperbase.util;

import net.minecraft.block.Block;
import net.minecraft.block.PressurePlateBlock;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.event.RegistryEvent;
import tv.mapper.mapperbase.block.CustomBlock;
import tv.mapper.mapperbase.block.CustomPressurePlateBlock;
import tv.mapper.mapperbase.block.CustomSlabBlock;
import tv.mapper.mapperbase.block.CustomStairsBlock;
import tv.mapper.mapperbase.block.CustomWallBlock;

public class RegistryUtils
{
    /**
     * Registers a Block with its variants.
     * @param event
     *        The RegistryEvent
     * @param name
     *        The Block registry name
     * @param stairs
     *        If true, stairs variant will be registered
     * @param slab
     *        If true, slab variant will be registered
     * @param wall
     *        If true, wall variant will be registered
     * @param pressure
     *        If true, pressure plate variant will be registered
     */
    public static void createBlockWithVariants(RegistryEvent.Register<Block> event, String name, boolean stairs, boolean slab, boolean wall, boolean pressure, Material material, MaterialColor color, SoundType sound, ToolType toolType, float hardness, float resistance)
    {
        Block block; // Needed to register the stairs
        event.getRegistry().register(block = new CustomBlock(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(name));
        if(stairs)
            event.getRegistry().register(
                new CustomStairsBlock(() -> block.getDefaultState(), Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(
                    name + "_stairs"));
        if(slab)
            event.getRegistry().register(
                new CustomSlabBlock(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(name + "_slab"));
        if(wall)
            event.getRegistry().register(
                new CustomWallBlock(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(name + "_wall"));
        if(pressure)
            event.getRegistry().register(
                new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(material, color).doesNotBlockMovement().hardnessAndResistance(hardness).sound(
                    sound), toolType).setRegistryName(name + "_pressure_plate"));

    }

    /**
     * Registers only variants of specified block.
     * @param event
     *        The RegistryEvent
     * @param name
     *        The Block registry name
     * @param stairs
     *        If true, stairs variant will be registered
     * @param slab
     *        If true, slab variant will be registered
     * @param wall
     *        If true, wall variant will be registered
     * @param pressure
     *        If true, pressure plate variant will be registered
     */
    public static void createOnlyVariants(RegistryEvent.Register<Block> event, String name, boolean stairs, boolean slab, boolean wall, boolean pressure, Material material, MaterialColor color, SoundType sound, ToolType toolType, float hardness, float resistance)
    {
        Block block = new Block(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance)).setRegistryName(name);; // Needed to register the stairs
        if(stairs)
            event.getRegistry().register(
                new CustomStairsBlock(() -> block.getDefaultState(), Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(
                    name + "_stairs"));
        if(slab)
            event.getRegistry().register(
                new CustomSlabBlock(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(name + "_slab"));
        if(wall)
            event.getRegistry().register(
                new CustomWallBlock(Block.Properties.create(material, color).hardnessAndResistance(hardness, resistance).sound(sound), toolType).setRegistryName(name + "_wall"));
        if(pressure)
            event.getRegistry().register(
                new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, Block.Properties.create(material, color).hardnessAndResistance(hardness).sound(sound), toolType).setRegistryName(
                    name + "_pressure_plate"));

    }

    /**
     * Registers a Block with its variants.
     * @param event
     *        The RegistryEvent
     * @param group
     *        The ItemGroup name
     * @param block
     *        The associated block
     * @param stairs
     *        The associated stairs (send null to not generate ItemBlock for it)
     * @param slab
     *        The associated slab (send null to not generate ItemBlock for it)
     * @param wall
     *        The associated wall (send null to not generate ItemBlock for it)
     * @param pressure
     *        The associated pressure plate (send null tot no generate ItemBlock for it)
     */
    public static void createItemBlockWithVariants(RegistryEvent.Register<Item> event, ItemGroup group, Block block, Block stairs, Block slab, Block wall, Block pressure)
    {
        event.getRegistry().register(new BlockItem(block, new Item.Properties().group(group)).setRegistryName(block.getRegistryName()));
        if(stairs != null)
            event.getRegistry().register(new BlockItem(stairs, new Item.Properties().group(group)).setRegistryName(stairs.getRegistryName()));
        if(slab != null)
            event.getRegistry().register(new BlockItem(slab, new Item.Properties().group(group)).setRegistryName(slab.getRegistryName()));
        if(wall != null)
            event.getRegistry().register(new BlockItem(wall, new Item.Properties().group(group)).setRegistryName(wall.getRegistryName()));
        if(pressure != null)
            event.getRegistry().register(new BlockItem(pressure, new Item.Properties().group(group)).setRegistryName(pressure.getRegistryName()));
    }
}
