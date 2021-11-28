package tv.mapper.mapperbase.data.loot;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.entries.LootPoolEntryContainer;
import net.minecraft.world.level.storage.loot.entries.LootTableReference;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import tv.mapper.mapperbase.MapperBase;

@Mod.EventBusSubscriber(modid = MapperBase.MODID)
public class BaseLoot
{
    @SubscribeEvent
    public static void lootLoad(LootTableLoadEvent evt)
    {
        String prefix = "minecraft:chests/";
        String name = evt.getName().toString();

        if(name.startsWith(prefix))
        {
            String file = name.substring(name.indexOf(prefix) + prefix.length());
            switch(file)
            {
                case "simple_dungeon":
                    evt.getTable().addPool(getInjectPool(file));
                    break;
                default:
                    break;
            }
        }
    }

    public static LootPool getInjectPool(String entryName)
    {
        return LootPool.lootPool().add(getInjectEntry(entryName, 1)).setBonusRolls(UniformGenerator.between(0, 1)).name("mapperbase_inject").build();
    }

    @SuppressWarnings("rawtypes")
    private static LootPoolEntryContainer.Builder getInjectEntry(String name, int weight)
    {
        ResourceLocation table = new ResourceLocation(MapperBase.MODID, "inject/" + name);
        return LootTableReference.lootTableReference(table).setWeight(weight);
    }
}