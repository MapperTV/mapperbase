package tv.mapper.mapperbase.util;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.item.Item;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.config.BaseConfig.ClientConfig;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.FORGE, value = Dist.CLIENT)
public class TagViewer
{
    @SubscribeEvent
    public static void onTooltip(ItemTooltipEvent e)
    {
        if(!ClientConfig.ENABLE_TAG_VIEWER.get())
            return;

        if(!Screen.hasControlDown())
            return;

        List<ITextComponent> tooltips = e.getToolTip();
        Item item = e.getItemStack().getItem();
        Map<ResourceLocation, ITag<Item>> tagmap = ItemTags.getCollection().getTagMap();

        int count = 0;

        for(Entry<ResourceLocation, ITag<Item>> entry : tagmap.entrySet())
        {
            if(item.isIn(entry.getValue()))
            {
                tooltips.add(new StringTextComponent("Tag: " + entry.getKey().toString()).func_240699_a_(TextFormatting.ITALIC).func_240699_a_(TextFormatting.DARK_GRAY));
                count++;
            }
        }

        if(count <= 0)
            tooltips.add(new StringTextComponent("No tag found...").func_240699_a_(TextFormatting.ITALIC).func_240699_a_(TextFormatting.DARK_GRAY));
    }
}