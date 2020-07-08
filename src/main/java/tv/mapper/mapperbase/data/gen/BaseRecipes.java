package tv.mapper.mapperbase.data.gen;

import java.util.function.Consumer;

import net.minecraft.block.Block;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.data.SingleItemRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;
import tv.mapper.mapperbase.data.BaseTags;
import tv.mapper.mapperbase.item.BaseItems;

public class BaseRecipes extends RecipeProvider
{
    public BaseRecipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        ShapedRecipeBuilder.shapedRecipe(BaseItems.BOLT.get()).patternLine("x").patternLine("x").key('x', BaseTags.ForgeItems.NUGGETS_STEEL).addCriterion("has_steel_nugget",
            hasItem(BaseTags.ForgeItems.NUGGETS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.FLATTER_HAMMER.get()).patternLine("i").patternLine("/").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('/', Items.STICK).addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_stick", hasItem(Items.STICK)).build(consumer);

        // Steel blocks
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_SLAB.get(), 6).patternLine("iii").key('i', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).addCriterion("has_steel_block",
            hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK.get()).patternLine("i").patternLine("i").key('i', BaseBlocks.STEEL_SLAB.get()).addCriterion("has_steel_slab",
            hasItem(BaseBlocks.STEEL_SLAB.get())).build(consumer, "mapperbase:steel_block_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_STAIRS.get(), 4).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion(
            "has_steel_block", hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_WALL.get(), 6).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("###").patternLine("###").addCriterion("has_steel_block",
            hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_PRESSURE_PLATE.get()).key('#', BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).patternLine("##").addCriterion("has_steel_block",
            hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_FENCE.get(), 3).patternLine("isi").patternLine("isi").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('s', BaseTags.ForgeItems.RODS_STEEL).addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_steel_rod", hasItem(BaseTags.ForgeItems.RODS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_FENCE_GATE.get()).patternLine("sis").patternLine("sis").key('i', BaseTags.ForgeItems.INGOTS_STEEL).key('s',
            BaseTags.ForgeItems.RODS_STEEL).addCriterion("has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).addCriterion("has_steel_rod", hasItem(BaseTags.ForgeItems.RODS_STEEL)).build(consumer);

        // Concrete blocks
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE.get(), 4).key('G', Tags.Items.GRAVEL).key('S', Tags.Items.SAND).patternLine("GS").patternLine("SG").addCriterion("has_sand",
            hasItem(Tags.Items.SAND)).addCriterion("has_gravel", hasItem(Tags.Items.GRAVEL)).build(consumer, MapperBase.MODID + ":concrete_1");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE.get(), 4).key('G', Tags.Items.GRAVEL).key('S', Tags.Items.SAND).patternLine("GS").patternLine("SG").addCriterion("has_sand",
            hasItem(Tags.Items.SAND)).addCriterion("has_gravel", hasItem(Tags.Items.GRAVEL)).build(consumer, MapperBase.MODID + ":concrete_2");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_SLAB.get(), 6).patternLine("iii").key('i', BaseTags.Items.CONCRETE).addCriterion("has_concrete_block", hasItem(BaseTags.Items.CONCRETE)).build(
            consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE.get()).patternLine("i").patternLine("i").key('i', BaseBlocks.CONCRETE_SLAB.get()).addCriterion("has_concrete_slab",
            hasItem(BaseBlocks.CONCRETE_SLAB.get())).build(consumer, MapperBase.MODID + ":concrete_block_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_STAIRS.get(), 4).key('#', BaseTags.Items.CONCRETE).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_concrete_block",
            hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_WALL.get(), 6).key('#', BaseTags.Items.CONCRETE).patternLine("###").patternLine("###").addCriterion("has_concrete_block",
            hasItem(BaseTags.Items.CONCRETE)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_PRESSURE_PLATE.get()).key('#', BaseTags.Items.CONCRETE).patternLine("##").addCriterion("has_concrete_block", hasItem(BaseTags.Items.CONCRETE)).build(
            consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_FENCE.get(), 3).patternLine("isi").patternLine("isi").key('i', BaseTags.Items.CONCRETE).key('s', BaseBlocks.CONCRETE_SLAB.get()).addCriterion(
            "has_concrete", hasItem(BaseTags.Items.CONCRETE)).addCriterion("has_concrete_slab", hasItem(BaseBlocks.CONCRETE_SLAB.get())).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.CONCRETE_FENCE_GATE.get()).patternLine("sis").patternLine("sis").key('i', BaseTags.Items.CONCRETE).key('s', BaseBlocks.CONCRETE_SLAB.get()).addCriterion(
            "has_concrete", hasItem(BaseTags.Items.CONCRETE)).addCriterion("has_concrete_slab", hasItem(BaseBlocks.CONCRETE_SLAB.get())).build(consumer);
        basicRecipes(consumer, BaseBlocks.CONCRETE.get(), BaseBlocks.CONCRETE_SLAB.get(), BaseBlocks.CONCRETE_STAIRS.get(), BaseBlocks.CONCRETE_WALL.get(), BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), null,
            BaseBlocks.CONCRETE_FENCE.get(), BaseBlocks.CONCRETE_FENCE_GATE.get());

        // Rods
        ShapedRecipeBuilder.shapedRecipe(BaseItems.IRON_ROD.get(), 4).patternLine("x").patternLine("x").key('x', Tags.Items.INGOTS_IRON).addCriterion("has_iron_ingot", hasItem(Items.IRON_INGOT)).build(
            consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_ROD.get(), 4).patternLine("x").patternLine("x").key('x', BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);

        // Blasting iron to steel
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(Tags.Items.INGOTS_IRON), BaseItems.STEEL_INGOT.get(), 1.0f, 120).addCriterion("has_iron_ingot", hasItem(Tags.Items.INGOTS_IRON)).build(consumer,
            MapperBase.MODID + ":steel_ingot_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(Tags.Items.STORAGE_BLOCKS_IRON), BaseBlocks.STEEL_BLOCK.get(), 2.0f, 960).addCriterion("has_iron_block",
            hasItem(Tags.Items.STORAGE_BLOCKS_IRON)).build(consumer, MapperBase.MODID + ":steel_block_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(BaseTags.ForgeItems.PLATES_IRON), BaseItems.STEEL_PLATE.get(), 1.0f, 120).addCriterion("has_iron_plate",
            hasItem(BaseTags.ForgeItems.PLATES_IRON)).build(consumer, MapperBase.MODID + ":steel_plate_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromTag(BaseTags.ForgeItems.RODS_IRON), BaseItems.STEEL_ROD.get(), 1.0f, 120).addCriterion("has_iron_rod", hasItem(BaseTags.ForgeItems.RODS_IRON)).build(
            consumer, MapperBase.MODID + ":steel_rod_from_blasting");

        // Metal plates
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.IRON_PLATE.get()).addIngredient(Tags.Items.INGOTS_IRON).addIngredient(BaseItems.FLATTER_HAMMER.get()).addCriterion("has_iron_ingot",
            hasItem(Tags.Items.INGOTS_IRON)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_PLATE.get()).addIngredient(BaseTags.ForgeItems.INGOTS_STEEL).addIngredient(BaseItems.FLATTER_HAMMER.get()).addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);

        // Nugget to ingot and vice-versa
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_INGOT.get()).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseTags.ForgeItems.NUGGETS_STEEL).addCriterion("has_steel_nugget",
            hasItem(BaseTags.ForgeItems.NUGGETS_STEEL)).setGroup("steel_ingot").build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_NUGGET.get(), 9).addIngredient(BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(
            consumer, MapperBase.MODID + ":steel_nugget_from_ingot");

        // Ingot to block and vice-versa
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK.get()).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseTags.ForgeItems.INGOTS_STEEL).addCriterion("has_steel_ingot",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_INGOT.get(), 9).addIngredient(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL).addCriterion("has_steel_block",
            hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_STEEL)).setGroup("steel_ingot").build(consumer, MapperBase.MODID + ":steel_ingot_from_block");

        // Tools
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_AXE.get()).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XX").patternLine("X#").patternLine(" #").addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_PICKAXE.get()).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine(" # ").patternLine(" # ").addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SHOVEL.get()).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X").patternLine("#").patternLine("#").addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SWORD.get()).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X").patternLine("X").patternLine("#").addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HOE.get()).key('#', Items.STICK).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XX").patternLine(" #").patternLine(" #").addCriterion(
            "has_steel_ingot", hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_BOOTS.get()).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X X").patternLine("X X").addCriterion("has_steel",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_CHESTPLATE.get()).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("X X").patternLine("XXX").patternLine("XXX").addCriterion("has_steel",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HELMET.get()).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine("X X").addCriterion("has_steel",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_LEGGINGS.get()).key('X', BaseTags.ForgeItems.INGOTS_STEEL).patternLine("XXX").patternLine("X X").patternLine("X X").addCriterion("has_steel",
            hasItem(BaseTags.ForgeItems.INGOTS_STEEL)).build(consumer);

        CookingRecipeBuilder.blastingRecipe(
            Ingredient.fromItems(Items.IRON_NUGGET, BaseItems.STEEL_PICKAXE.get(), BaseItems.STEEL_SHOVEL.get(), BaseItems.STEEL_AXE.get(), BaseItems.STEEL_HOE.get(), BaseItems.STEEL_SWORD.get(),
                BaseItems.STEEL_HELMET.get(), BaseItems.STEEL_CHESTPLATE.get(), BaseItems.STEEL_LEGGINGS.get(), BaseItems.STEEL_BOOTS.get(), BaseItems.STEEL_HORSE_ARMOR.get()),
            BaseItems.STEEL_NUGGET.get(), 0.1F, 100).addCriterion("has_iron_nugget", hasItem(Items.IRON_NUGGET)).addCriterion("has_steel_pickaxe", hasItem(BaseItems.STEEL_PICKAXE.get())).addCriterion(
                "has_steel_shovel", hasItem(BaseItems.STEEL_SHOVEL.get())).addCriterion("has_steel_axe", hasItem(BaseItems.STEEL_AXE.get())).addCriterion("has_steel_hoe",
                    hasItem(BaseItems.STEEL_HOE.get())).addCriterion("has_steel_sword", hasItem(BaseItems.STEEL_SWORD.get())).addCriterion("has_steel_helmet",
                        hasItem(BaseItems.STEEL_HELMET.get())).addCriterion("has_steel_chestplate", hasItem(BaseItems.STEEL_CHESTPLATE.get())).addCriterion("has_steel_leggings",
                            hasItem(BaseItems.STEEL_LEGGINGS.get())).addCriterion("has_steel_boots", hasItem(BaseItems.STEEL_BOOTS.get())).addCriterion("has_steel_horse_armor",
                                hasItem(BaseItems.STEEL_HORSE_ARMOR.get())).build(consumer, MapperBase.MODID + ":steel_nugget_from_blasting");

        // Asphalt
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT.get()).key('G', Tags.Items.GRAVEL).key('B', BaseItems.RAW_BITUMEN.get()).key('S', Tags.Items.SAND).patternLine("SB").patternLine("BG").addCriterion(
            "has_raw_bitumen", hasItem(BaseItems.RAW_BITUMEN.get())).setGroup("asphalt").build(consumer, MapperBase.MODID + ":asphalt1");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT.get()).key('G', Tags.Items.GRAVEL).key('B', BaseItems.RAW_BITUMEN.get()).key('S', Tags.Items.SAND).patternLine("BS").patternLine("GB").addCriterion(
            "has_raw_bitumen", hasItem(BaseItems.RAW_BITUMEN.get())).setGroup("asphalt").build(consumer, MapperBase.MODID + ":asphalt2");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT.get()).key('G', Tags.Items.GRAVEL).key('B', BaseItems.RAW_BITUMEN.get()).key('S', Tags.Items.SAND).patternLine("GB").patternLine("BS").addCriterion(
            "has_raw_bitumen", hasItem(BaseItems.RAW_BITUMEN.get())).setGroup("asphalt").build(consumer, MapperBase.MODID + ":asphalt3");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT.get()).key('G', Tags.Items.GRAVEL).key('B', BaseItems.RAW_BITUMEN.get()).key('S', Tags.Items.SAND).patternLine("BG").patternLine("SB").addCriterion(
            "has_raw_bitumen", hasItem(BaseItems.RAW_BITUMEN.get())).setGroup("asphalt").build(consumer, MapperBase.MODID + ":asphalt4");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT.get()).patternLine("i").patternLine("i").key('i', BaseBlocks.ASPHALT_SLAB.get()).addCriterion("has_asphalt_slab",
            hasItem(BaseBlocks.ASPHALT_SLAB.get())).build(consumer, MapperBase.MODID + ":asphalt_block_from_slabs");
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT_SLAB.get(), 6).patternLine("iii").key('i', BaseTags.Items.ASPHALT).addCriterion("has_asphalt_block", hasItem(BaseTags.Items.ASPHALT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT_STAIRS.get(), 4).key('#', BaseTags.Items.ASPHALT).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_asphalt_block",
            hasItem(BaseTags.Items.ASPHALT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.ASPHALT_PRESSURE_PLATE.get()).key('#', BaseTags.Items.ASPHALT).patternLine("##").addCriterion("has_asphalt_block", hasItem(BaseTags.Items.ASPHALT)).build(
            consumer);
        basicRecipes(consumer, BaseBlocks.ASPHALT.get(), BaseBlocks.ASPHALT_SLAB.get(), BaseBlocks.ASPHALT_STAIRS.get(), null, BaseBlocks.ASPHALT_PRESSURE_PLATE.get(), null, null, null);

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.BITUMEN_BLOCK.get()).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseItems.RAW_BITUMEN.get()).addCriterion("has_raw_bitumen",
            hasItem(BaseItems.RAW_BITUMEN.get())).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.RAW_BITUMEN.get(), 9).addIngredient(BaseTags.ForgeItems.STORAGE_BLOCKS_BITUMEN).addCriterion("has_bitumen_block",
            hasItem(BaseTags.ForgeItems.STORAGE_BLOCKS_BITUMEN)).build(consumer, MapperBase.MODID + ":raw_bitumen_from_block");

        // Ore
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(BaseItems.BITUMEN_ORE_ITEM.get()), BaseItems.RAW_BITUMEN.get(), 0.1f, 100).addCriterion("has_bitumen_ore",
            hasItem(BaseItems.BITUMEN_ORE_ITEM.get())).build(consumer, MapperBase.MODID + ":raw_bitumen_from_blasting");
        CookingRecipeBuilder.smeltingRecipe(Ingredient.fromItems(BaseItems.BITUMEN_ORE_ITEM.get()), BaseItems.RAW_BITUMEN.get(), 0.1f, 200).addCriterion("has_bitumen_ore",
            hasItem(BaseItems.BITUMEN_ORE_ITEM.get())).build(consumer, MapperBase.MODID + ":raw_bitumen_from_smelting");
    }

    private void basicRecipes(Consumer<IFinishedRecipe> consumer, Block base, Block slab, Block stairs, Block wall, Block pressure, Block button, Block fence, Block fence_gate)
    {
        String base_name = base.getRegistryName().getPath();

        if(slab != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), slab, 2).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_slab_from_" + base_name + "_stonecutting");
        if(stairs != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), stairs).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_stairs_from_" + base_name + "_stonecutting");
        if(wall != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), wall).addCriterion("has_" + base_name, hasItem(base)).build(consumer, base_name + "_wall_from_" + base_name + "_stonecutting");
        if(pressure != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), pressure, 2).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_pressure_plate_from_" + base_name + "_stonecutting");
        if(button != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), button, 2).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_button_plate_from_" + base_name + "_stonecutting");
        if(fence != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), fence).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_fence_plate_from_" + base_name + "_stonecutting");
        if(fence_gate != null)
            SingleItemRecipeBuilder.stonecuttingRecipe(Ingredient.fromItems(base), fence_gate).addCriterion("has_" + base_name, hasItem(base)).build(consumer,
                base_name + "_fence_gate_plate_from_" + base_name + "_stonecutting");
    }
}