package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.item.BaseItems;

public class BaseLang extends LanguageProvider
{
    private String lang;

    public BaseLang(DataGenerator generator, String modid, String lang)
    {
        super(generator, modid, lang);
        this.lang = lang;
    }

    @Override
    protected void addTranslations()
    {
        switch(lang)
        {
            default:
            case "en_us":
                add(BaseBlocks.STEEL_BLOCK.get(), "Steel Block");
                add(BaseBlocks.STEEL_SLAB.get(), "Steel Slab");
                add(BaseBlocks.STEEL_STAIRS.get(), "Steel Stairs");
                add(BaseBlocks.STEEL_WALL.get(), "Steel Wall");
                add(BaseBlocks.STEEL_PRESSURE_PLATE.get(), "Steel Pressure Plate");
                add(BaseBlocks.STEEL_FENCE.get(), "Steel Fence");
                add(BaseBlocks.STEEL_FENCE_GATE.get(), "Steel Fence Gate");

                add(BaseBlocks.CONCRETE.get(), "Concrete");
                add(BaseBlocks.CONCRETE_SLAB.get(), "Concrete Slab");
                add(BaseBlocks.CONCRETE_STAIRS.get(), "Concrete Stairs");
                add(BaseBlocks.CONCRETE_WALL.get(), "Concrete Wall");
                add(BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), "Concrete Pressure Plate");
                add(BaseBlocks.CONCRETE_FENCE.get(), "Concrete Fence");
                add(BaseBlocks.CONCRETE_FENCE_GATE.get(), "Concrete Fence Gate");

                add(BaseBlocks.ASPHALT.get(), "Asphalt");
                add(BaseBlocks.ASPHALT_SLAB.get(), "Asphalt Slab");
                add(BaseBlocks.ASPHALT_STAIRS.get(), "Asphalt Stairs");
                add(BaseBlocks.ASPHALT_PRESSURE_PLATE.get(), "Asphalt Pressure Plate");

                add(BaseItems.RAW_BITUMEN.get(), "Raw Asphalt");
                add(BaseBlocks.BITUMEN_BLOCK.get(), "Bitumen Block");

                add(BaseItems.BOLT.get(), "Bolt");
                add(BaseItems.FLATTER_HAMMER.get(), "Flatter Hammer");
                add(BaseItems.IRON_PLATE.get(), "Iron Plate");
                add(BaseItems.IRON_ROD.get(), "Iron Rod");
                add(BaseItems.STEEL_INGOT.get(), "Steel Ingot");
                add(BaseItems.STEEL_NUGGET.get(), "Steel Nugget");
                add(BaseItems.STEEL_PLATE.get(), "Steel Plate");
                add(BaseItems.STEEL_ROD.get(), "Steel Rod");

                add(BaseItems.STEEL_AXE.get(), "Steel Axe");
                add(BaseItems.STEEL_PICKAXE.get(), "Steel Pickaxe");
                add(BaseItems.STEEL_SHOVEL.get(), "Steel Shovel");
                add(BaseItems.STEEL_HOE.get(), "Steel Hoe");
                add(BaseItems.STEEL_SWORD.get(), "Steel Sword");

                add(BaseItems.STEEL_HELMET.get(), "Steel Helmet");
                add(BaseItems.STEEL_CHESTPLATE.get(), "Steel Chestplate");
                add(BaseItems.STEEL_LEGGINGS.get(), "Steel Leggings");
                add(BaseItems.STEEL_BOOTS.get(), "Steel Boots");

                add(BaseItems.STEEL_HORSE_ARMOR.get(), "Steel Horse Armor");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
            case "fr_fr":
                add(BaseBlocks.STEEL_BLOCK.get(), "Bloc d'acier");
                add(BaseBlocks.STEEL_SLAB.get(), "Dalle en acier");
                add(BaseBlocks.STEEL_STAIRS.get(), "Escalier en acier");
                add(BaseBlocks.STEEL_WALL.get(), "Muret en acier");
                add(BaseBlocks.STEEL_PRESSURE_PLATE.get(), "Plaque de pression en acier");
                add(BaseBlocks.STEEL_FENCE.get(), "Barrière en acier");
                add(BaseBlocks.STEEL_FENCE_GATE.get(), "Portillon en acier");

                add(BaseBlocks.CONCRETE.get(), "Bloc de béton");
                add(BaseBlocks.CONCRETE_SLAB.get(), "Dalle en béton");
                add(BaseBlocks.CONCRETE_STAIRS.get(), "Escalier en béton");
                add(BaseBlocks.CONCRETE_WALL.get(), "Muret en béton");
                add(BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), "Plaque de pression en béton");
                add(BaseBlocks.CONCRETE_FENCE.get(), "Barrière en béton");
                add(BaseBlocks.CONCRETE_FENCE_GATE.get(), "Portillon en béton");

                add(BaseBlocks.ASPHALT.get(), "Asphalte");
                add(BaseBlocks.ASPHALT_SLAB.get(), "Dalle d'asphalte");
                add(BaseBlocks.ASPHALT_STAIRS.get(), "Escaliers d'asphalte");
                add(BaseBlocks.ASPHALT_PRESSURE_PLATE.get(), "Plaque de pression d'asphalte");

                add(BaseItems.RAW_BITUMEN.get(), "Bitume brut");
                add(BaseBlocks.BITUMEN_BLOCK.get(), "Bloc de bitume");

                add(BaseItems.BOLT.get(), "Boulon");
                add(BaseItems.FLATTER_HAMMER.get(), "Masse");
                add(BaseItems.IRON_PLATE.get(), "Plaque de fer");
                add(BaseItems.IRON_ROD.get(), "Barre de fer");
                add(BaseItems.STEEL_INGOT.get(), "Lingot d'acier");
                add(BaseItems.STEEL_NUGGET.get(), "Pépite d'acier");
                add(BaseItems.STEEL_PLATE.get(), "Plaque d'acier");
                add(BaseItems.STEEL_ROD.get(), "Barre d'acier");

                add(BaseItems.STEEL_AXE.get(), "Hache en acier");
                add(BaseItems.STEEL_PICKAXE.get(), "Pioche en acier");
                add(BaseItems.STEEL_SHOVEL.get(), "Pelle en acier");
                add(BaseItems.STEEL_HOE.get(), "Houe en acier");
                add(BaseItems.STEEL_SWORD.get(), "Epee en acier");

                add(BaseItems.STEEL_HELMET.get(), "Casque en acier");
                add(BaseItems.STEEL_CHESTPLATE.get(), "Plastron en acier");
                add(BaseItems.STEEL_LEGGINGS.get(), "Jambières en acier");
                add(BaseItems.STEEL_BOOTS.get(), "Bottes en acier");

                add(BaseItems.STEEL_HORSE_ARMOR.get(), "Armure en acier pour cheval");

                add("itemGroup.mapperbase_group", "Mapper Base");
                break;
        }
    }
}