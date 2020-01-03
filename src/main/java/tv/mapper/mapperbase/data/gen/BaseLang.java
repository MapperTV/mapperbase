package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.item.BaseItems;

public class BaseLang extends LanguageProvider
{
    private String lang;

    public BaseLang(DataGenerator generator, String lang)
    {
        super(generator, MapperBase.MODID, lang);
        this.lang = lang;
    }

    @Override
    protected void addTranslations()
    {
        switch(lang)
        {
            default:
            case "en_us":
                add(BaseBlocks.STEEL_BLOCK, "Steel Block");

                add(BaseItems.BOLT, "Bolt");
                add(BaseItems.FLATTER_HAMMER, "Flatter Hammer");
                add(BaseItems.IRON_PLATE, "Iron Plate");
                add(BaseItems.IRON_ROD, "Iron Rod");
                add(BaseItems.STEEL_INGOT, "Steel Ingot");
                add(BaseItems.STEEL_NUGGET, "Steel Nugget");
                add(BaseItems.STEEL_PLATE, "Steel Plate");
                add(BaseItems.STEEL_ROD, "Steel Rod");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
            case "fr_fr":
                add(BaseBlocks.STEEL_BLOCK, "Bloc d'acier");

                add(BaseItems.BOLT, "Boulon");
                add(BaseItems.FLATTER_HAMMER, "Masse");
                add(BaseItems.IRON_PLATE, "Plaque de fer");
                add(BaseItems.IRON_ROD, "Barre de fer");
                add(BaseItems.STEEL_INGOT, "Lingot d'acier");
                add(BaseItems.STEEL_NUGGET, "Pepite d'acier");
                add(BaseItems.STEEL_PLATE, "Plaque d'acier");
                add(BaseItems.STEEL_ROD, "Barre d'acier");
                
                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
        }
    }
}