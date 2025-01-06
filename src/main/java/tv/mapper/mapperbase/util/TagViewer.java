package tv.mapper.mapperbase.util;

import java.util.Iterator;
import java.util.List;

import com.mojang.datafixers.util.Pair;

import net.minecraft.ChatFormatting;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.player.ItemTooltipEvent;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.config.MB_Config;

@EventBusSubscriber(modid = MapperBase.MODID)
public class TagViewer
{
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent event)
    {
        if(!MB_Config.enableTagViewer)
            return;

        if(!Screen.hasControlDown())
            return;

        List<Component> tooltips = event.getToolTip();
        ItemStack item = event.getItemStack();

        Iterator<Pair<TagKey<Item>, Named<Item>>> tagmap = BuiltInRegistries.ITEM.getTags().iterator();

        int count = 0;

        while(tagmap.hasNext())
        {
            TagKey<Item> key = tagmap.next().getFirst();

            if(item.is(key))
            {
                tooltips.add(Component.literal("Tag: " + key.location()).setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true)));
                count++;
            }
        }

        if(count <= 0)
            tooltips.add(Component.literal("No tag found").setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true)));
        else
            tooltips.add(Component.literal("Total tags: " + count).setStyle(Style.EMPTY.withColor(ChatFormatting.DARK_GRAY).withItalic(true)));
    }
}
