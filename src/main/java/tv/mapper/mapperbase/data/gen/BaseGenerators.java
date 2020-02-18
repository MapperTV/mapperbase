package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;
import tv.mapper.mapperbase.MapperBase;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new BaseRecipes(generator));
        generator.addProvider(new BaseLootTables(generator));
        generator.addProvider(new BaseBlockStates(generator, MapperBase.MODID, event.getExistingFileHelper()));
        generator.addProvider(new BaseBlockModels(generator, MapperBase.MODID, event.getExistingFileHelper()));
        generator.addProvider(new BaseItemModels(generator, MapperBase.MODID, event.getExistingFileHelper()));

        generator.addProvider(new BaseBlockTags(generator));
        generator.addProvider(new BaseItemTags(generator));

        generator.addProvider(new BaseLang(generator, MapperBase.MODID, "en_us"));
        generator.addProvider(new BaseLang(generator, MapperBase.MODID, "fr_fr"));
    }
}