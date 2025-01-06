package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.item.MB_Items;

public class LangGenerator extends LanguageProvider
{
    private String lang;

    public LangGenerator(PackOutput output, String modid, String locale)
    {
        super(output, modid, locale);
        this.lang = locale;
    }

    @Override
    protected void addTranslations()
    {
        switch(lang)
        {
            default:
            case "en_us":
                add(MB_Blocks.STEEL_BLOCK.get(), "Steel Block");
                add(MB_Blocks.STEEL_SLAB.get(), "Steel Slab");
                add(MB_Blocks.STEEL_STAIRS.get(), "Steel Stairs");
                add(MB_Blocks.STEEL_WALL.get(), "Steel Wall");
                add(MB_Blocks.STEEL_PRESSURE_PLATE.get(), "Steel Pressure Plate");
                add(MB_Blocks.STEEL_FENCE.get(), "Steel Fence");
                add(MB_Blocks.STEEL_FENCE_GATE.get(), "Steel Fence Gate");
                add(MB_Blocks.STEEL_BUTTON.get(), "Steel Button");

                add(MB_Items.PIG_IRON_CHUNK.get(), "Pig Iron Chunk");
                add(MB_Items.RAW_STEEL.get(), "Raw Steel");
                add(MB_Items.RIVET.get(), "Rivet");
                add(MB_Items.FLATTER_HAMMER.get(), "Flatter Hammer");
                add(MB_Items.REINFORCED_FLATTER_HAMMER.get(), "Reinforced Flatter Hammer");
                add(MB_Items.IRON_PLATE.get(), "Iron Plate");
                add(MB_Items.IRON_ROD.get(), "Iron Rod");
                add(MB_Items.STEEL_INGOT.get(), "Steel Ingot");
                add(MB_Items.STEEL_NUGGET.get(), "Steel Nugget");
                add(MB_Items.STEEL_PLATE.get(), "Steel Plate");
                add(MB_Items.STEEL_ROD.get(), "Steel Rod");

                add(MB_Items.STEEL_AXE.get(), "Steel Axe");
                add(MB_Items.STEEL_PICKAXE.get(), "Steel Pickaxe");
                add(MB_Items.STEEL_SHOVEL.get(), "Steel Shovel");
                add(MB_Items.STEEL_HOE.get(), "Steel Hoe");
                add(MB_Items.STEEL_SWORD.get(), "Steel Sword");

                add(MB_Items.STEEL_HELMET.get(), "Steel Helmet");
                add(MB_Items.STEEL_CHESTPLATE.get(), "Steel Chestplate");
                add(MB_Items.STEEL_LEGGINGS.get(), "Steel Leggings");
                add(MB_Items.STEEL_BOOTS.get(), "Steel Boots");

                add(MB_Items.STEEL_HORSE_ARMOR.get(), "Steel Horse Armor");

                add("itemGroup.mapperbase", "Mapper Base");
                break;
            case "fr_fr":
                add(MB_Blocks.STEEL_BLOCK.get(), "Bloc d'acier");
                add(MB_Blocks.STEEL_SLAB.get(), "Dalle en acier");
                add(MB_Blocks.STEEL_STAIRS.get(), "Escalier en acier");
                add(MB_Blocks.STEEL_WALL.get(), "Muret en acier");
                add(MB_Blocks.STEEL_PRESSURE_PLATE.get(), "Plaque de pression en acier");
                add(MB_Blocks.STEEL_FENCE.get(), "Barrière en acier");
                add(MB_Blocks.STEEL_FENCE_GATE.get(), "Portillon en acier");
                add(MB_Blocks.STEEL_BUTTON.get(), "Bouton en acier");

                add(MB_Items.PIG_IRON_CHUNK.get(), "Fonte brute");
                add(MB_Items.RAW_STEEL.get(), "Acier brut");
                add(MB_Items.RIVET.get(), "Rivet");
                add(MB_Items.FLATTER_HAMMER.get(), "Marteau plat");
                add(MB_Items.REINFORCED_FLATTER_HAMMER.get(), "Marteau plat renforcé");
                add(MB_Items.IRON_PLATE.get(), "Plaque de fer");
                add(MB_Items.IRON_ROD.get(), "Barre de fer");
                add(MB_Items.STEEL_INGOT.get(), "Lingot d'acier");
                add(MB_Items.STEEL_NUGGET.get(), "Pépite d'acier");
                add(MB_Items.STEEL_PLATE.get(), "Plaque d'acier");
                add(MB_Items.STEEL_ROD.get(), "Barre d'acier");

                add(MB_Items.STEEL_AXE.get(), "Hache en acier");
                add(MB_Items.STEEL_PICKAXE.get(), "Pioche en acier");
                add(MB_Items.STEEL_SHOVEL.get(), "Pelle en acier");
                add(MB_Items.STEEL_HOE.get(), "Houe en acier");
                add(MB_Items.STEEL_SWORD.get(), "Epee en acier");

                add(MB_Items.STEEL_HELMET.get(), "Casque en acier");
                add(MB_Items.STEEL_CHESTPLATE.get(), "Plastron en acier");
                add(MB_Items.STEEL_LEGGINGS.get(), "Jambières en acier");
                add(MB_Items.STEEL_BOOTS.get(), "Bottes en acier");

                add(MB_Items.STEEL_HORSE_ARMOR.get(), "Armure en acier pour cheval");

                add("itemGroup.mapperbase", "Mapper Base");
                break;
        }
    }
}