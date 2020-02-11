package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseGenerators
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event)
    {
        DataGenerator generator = event.getGenerator();
        generator.addProvider(new BaseRecipes(generator));
        generator.addProvider(new BaseLootTables(generator));
        generator.addProvider(new BaseBlockStates(generator, event.getExistingFileHelper()));
        generator.addProvider(new BaseBlockModels(generator, event.getExistingFileHelper()));
        generator.addProvider(new BaseItemModels(generator, event.getExistingFileHelper()));

        generator.addProvider(new BaseBlockTags(generator));
        generator.addProvider(new BaseItemTags(generator));

        generator.addProvider(new BaseLang(generator, "en_us"));
        generator.addProvider(new BaseLang(generator, "fr_fr"));
    }
}