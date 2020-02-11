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
                add(BaseBlocks.STEEL_SLAB, "Steel Slab");

                add(BaseItems.BOLT, "Bolt");
                add(BaseItems.FLATTER_HAMMER, "Flatter Hammer");
                add(BaseItems.IRON_PLATE, "Iron Plate");
                add(BaseItems.IRON_ROD, "Iron Rod");
                add(BaseItems.STEEL_INGOT, "Steel Ingot");
                add(BaseItems.STEEL_NUGGET, "Steel Nugget");
                add(BaseItems.STEEL_PLATE, "Steel Plate");
                add(BaseItems.STEEL_ROD, "Steel Rod");

                add(BaseItems.STEEL_AXE, "Steel Axe");
                add(BaseItems.STEEL_PICKAXE, "Steel Pickaxe");
                add(BaseItems.STEEL_SHOVEL, "Steel Shovel");
                add(BaseItems.STEEL_HOE, "Steel Hoe");
                add(BaseItems.STEEL_SWORD, "Steel Sword");

                add(BaseItems.STEEL_HELMET, "Steel Helmet");
                add(BaseItems.STEEL_CHESTPLATE, "Steel Chestplate");
                add(BaseItems.STEEL_LEGGINGS, "Steel Leggings");
                add(BaseItems.STEEL_BOOTS, "Steel Boots");
                
                add(BaseItems.STEEL_HORSE_ARMOR, "Steel Horse Armor");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
            case "fr_fr":
                add(BaseBlocks.STEEL_BLOCK, "Bloc d'acier");
                add(BaseBlocks.STEEL_SLAB, "Dalle d'acier");

                add(BaseItems.BOLT, "Boulon");
                add(BaseItems.FLATTER_HAMMER, "Masse");
                add(BaseItems.IRON_PLATE, "Plaque de fer");
                add(BaseItems.IRON_ROD, "Barre de fer");
                add(BaseItems.STEEL_INGOT, "Lingot d'acier");
                add(BaseItems.STEEL_NUGGET, "Pepite d'acier");
                add(BaseItems.STEEL_PLATE, "Plaque d'acier");
                add(BaseItems.STEEL_ROD, "Barre d'acier");

                add(BaseItems.STEEL_AXE, "Hache en acier");
                add(BaseItems.STEEL_PICKAXE, "Pioche en acier");
                add(BaseItems.STEEL_SHOVEL, "Pelle en acier");
                add(BaseItems.STEEL_HOE, "Houe en acier");
                add(BaseItems.STEEL_SWORD, "Epee en acier");

                add(BaseItems.STEEL_HELMET, "Casque en acier");
                add(BaseItems.STEEL_CHESTPLATE, "Plastron en acier");
                add(BaseItems.STEEL_LEGGINGS, "Jambieres en acier");
                add(BaseItems.STEEL_BOOTS, "Bottes en acier");

                add(BaseItems.STEEL_HORSE_ARMOR, "Armure en acier pour cheval");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
        }
    }
}