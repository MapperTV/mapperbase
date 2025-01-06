package tv.mapper.mapperbase.config;

import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;
import tv.mapper.mapperbase.MapperBase;

@EventBusSubscriber(modid = MapperBase.MODID, bus = EventBusSubscriber.Bus.MOD)
public class MB_Config
{
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    private static final ModConfigSpec.BooleanValue ENABLE_TAG_VIEWER_BOOLEAN_VALUE = BUILDER.comment("Enable the Tag Viewer (press CTRL while cursor being on item). This is client-side only.").define("enableTagViewer", false);
    
    public static final ModConfigSpec SPEC = BUILDER.build();
    
    public static boolean enableTagViewer;

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event)
    {
        enableTagViewer = ENABLE_TAG_VIEWER_BOOLEAN_VALUE.get();
    }
}
