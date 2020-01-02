package tv.mapper.mapperbase.block;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
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

    @SubscribeEvent
    public static void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().register(new Block(Block.Properties.create(Material.IRON, MaterialColor.STONE).hardnessAndResistance(5.0F, 6.0F).sound(SoundType.LANTERN)).setRegistryName("steel_block"));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().register(new BlockItem(STEEL_BLOCK, new Item.Properties().group(BaseGroups.MAPPERBASE)).setRegistryName(STEEL_BLOCK.getRegistryName()));
    }
}
