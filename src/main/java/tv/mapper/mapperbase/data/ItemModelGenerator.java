package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.data.BaseItemModelProvider;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.item.MB_Items;

public class ItemModelGenerator extends BaseItemModelProvider
{

    public ItemModelGenerator(PackOutput output, String modid, ExistingFileHelper existingFileHelper, String name)
    {
        super(output, modid, existingFileHelper, name);
    }

    @Override
    protected void registerModels()
    {
        withExistingParent(MB_Blocks.STEEL_BLOCK.getId().getPath(), modLoc("block/steel_block"));
        registerBlockBasics("steel", false, true, true, true, true, true, true, true);

        basicItem(MB_Items.STEEL_INGOT.get());
        basicItem(MB_Items.STEEL_NUGGET.get());
        basicItem(MB_Items.RAW_STEEL.get());
        basicItem(MB_Items.PIG_IRON_CHUNK.get());
        handheldItem(MB_Items.STEEL_ROD.get());
        basicItem(MB_Items.STEEL_PLATE.get());

        handheldItem(MB_Items.STEEL_AXE.get());
        handheldItem(MB_Items.STEEL_PICKAXE.get());
        handheldItem(MB_Items.STEEL_SHOVEL.get());
        handheldItem(MB_Items.STEEL_HOE.get());
        handheldItem(MB_Items.STEEL_SWORD.get());

        basicItem(MB_Items.STEEL_HELMET.get());
        basicItem(MB_Items.STEEL_CHESTPLATE.get());
        basicItem(MB_Items.STEEL_LEGGINGS.get());
        basicItem(MB_Items.STEEL_BOOTS.get());

        basicItem(MB_Items.STEEL_HORSE_ARMOR.get());

        basicItem(MB_Items.IRON_PLATE.get());
        handheldItem(MB_Items.IRON_ROD.get());
        handheldItem(MB_Items.FLATTER_HAMMER.get());
        handheldItem(MB_Items.REINFORCED_FLATTER_HAMMER.get());
        basicItem(MB_Items.RIVET.get());
    }
}
