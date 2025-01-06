package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.item.MB_Items;

public class ItemModelGenerator extends ItemModelProvider
{

    public ItemModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, MapperBase.MODID, existingFileHelper);
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
        withExistingParent(MB_Items.STEEL_ROD.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_rod"));
        basicItem(MB_Items.STEEL_PLATE.get());

        withExistingParent(MB_Items.STEEL_AXE.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_axe"));
        withExistingParent(MB_Items.STEEL_PICKAXE.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_pickaxe"));
        withExistingParent(MB_Items.STEEL_SHOVEL.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_shovel"));
        withExistingParent(MB_Items.STEEL_HOE.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_hoe"));
        withExistingParent(MB_Items.STEEL_SWORD.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/steel_sword"));

        basicItem(MB_Items.STEEL_HELMET.get());
        basicItem(MB_Items.STEEL_CHESTPLATE.get());
        basicItem(MB_Items.STEEL_LEGGINGS.get());
        basicItem(MB_Items.STEEL_BOOTS.get());

        basicItem(MB_Items.STEEL_HORSE_ARMOR.get());

        basicItem(MB_Items.IRON_PLATE.get());
        withExistingParent(MB_Items.IRON_ROD.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/iron_rod"));
        withExistingParent(MB_Items.FLATTER_HAMMER.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/flatter_hammer"));
        withExistingParent(MB_Items.REINFORCED_FLATTER_HAMMER.getId().getPath(), mcLoc("item/handheld")).texture("layer0", modLoc("item/reinforced_flatter_hammer"));
        basicItem(MB_Items.RIVET.get());
    }

    protected void registerBlockBasics(String name, boolean block, boolean slab, boolean stairs, boolean wall, boolean pressure, boolean fence, boolean fence_gate, boolean button)
    {
        if(block)
            getBuilder(name).parent(new UncheckedModelFile(modid + ":block/" + name));
        if(slab)
            getBuilder(name + "_slab").parent(new UncheckedModelFile(modid + ":block/" + name + "_slab"));
        if(stairs)
            getBuilder(name + "_stairs").parent(new UncheckedModelFile(modid + ":block/" + name + "_stairs"));
        if(wall)
            getBuilder(name + "_wall").parent(new UncheckedModelFile(modid + ":block/" + name + "_wall_inventory"));
        if(pressure)
            getBuilder(name + "_pressure_plate").parent(new UncheckedModelFile(modid + ":block/" + name + "_pressure_plate"));
        if(fence)
            getBuilder(name + "_fence").parent(new UncheckedModelFile(modid + ":block/" + name + "_fence_inventory"));
        if(fence_gate)
            getBuilder(name + "_fence_gate").parent(new UncheckedModelFile(modid + ":block/" + name + "_fence_gate"));
        if(button)
            getBuilder(name + "_button").parent(new UncheckedModelFile(modid + ":block/" + name + "_button_inventory"));
    }
}
