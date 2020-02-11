package tv.mapper.mapperbase.data.gen;

import java.util.function.Consumer;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import tv.mapper.mapperbase.block.BaseBlocks;
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
        ShapedRecipeBuilder.shapedRecipe(BaseItems.BOLT).patternLine("x").patternLine("x").key('x', BaseItems.STEEL_NUGGET).addCriterion("has_steel_nugget",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_NUGGET)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.FLATTER_HAMMER).patternLine("i").patternLine("/").key('i', BaseItems.STEEL_INGOT).key('/', Items.STICK).addCriterion("has_steel_ingot",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_INGOT)).addCriterion("has_stick", InventoryChangeTrigger.Instance.forItems(Items.STICK)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_SLAB, 6).patternLine("iii").key('i', BaseBlocks.STEEL_BLOCK).addCriterion("has_steel_block",
            InventoryChangeTrigger.Instance.forItems(BaseBlocks.STEEL_BLOCK)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK).patternLine("i").patternLine("i").key('i', BaseBlocks.STEEL_SLAB).addCriterion("has_steel_slab",
            InventoryChangeTrigger.Instance.forItems(BaseBlocks.STEEL_SLAB)).build(consumer, "mapperbase:steel_block_from_slabs");

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_STAIRS, 4).key('#', BaseBlocks.STEEL_BLOCK).patternLine("#  ").patternLine("## ").patternLine("###").addCriterion("has_steel_block",
            this.hasItem(BaseBlocks.STEEL_BLOCK)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_WALL, 6).key('#', BaseBlocks.STEEL_BLOCK).patternLine("###").patternLine("###").addCriterion("has_steel_block",
            this.hasItem(BaseBlocks.STEEL_BLOCK)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_PRESSURE_PLATE).key('#', BaseBlocks.STEEL_BLOCK).patternLine("##").addCriterion("has_steel_block", this.hasItem(BaseBlocks.STEEL_BLOCK)).build(
            consumer);

        // Rods
        ShapedRecipeBuilder.shapedRecipe(BaseItems.IRON_ROD, 4).patternLine("x").patternLine("x").key('x', Items.IRON_INGOT).addCriterion("has_iron_ingot",
            InventoryChangeTrigger.Instance.forItems(Items.IRON_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_ROD, 4).patternLine("x").patternLine("x").key('x', BaseItems.STEEL_INGOT).addCriterion("has_steel_ingot",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_INGOT)).build(consumer);

        // Blasting iron to steel
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_INGOT), BaseItems.STEEL_INGOT, 1.0f, 120).addCriterion("has_iron_ingot", this.hasItem(Items.IRON_INGOT)).build(consumer,
            "mapperbase:steel_ingot_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_BLOCK), BaseBlocks.STEEL_BLOCK, 2.0f, 960).addCriterion("has_iron_block", this.hasItem(Items.IRON_BLOCK)).build(consumer,
            "mapperbase:steel_block_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(BaseItems.IRON_PLATE), BaseItems.STEEL_PLATE, 1.0f, 120).addCriterion("has_iron_plate", this.hasItem(BaseItems.IRON_PLATE)).build(
            consumer, "mapperbase:steel_plate_from_blasting");
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(BaseItems.IRON_ROD), BaseItems.STEEL_ROD, 1.0f, 120).addCriterion("has_iron_rod", this.hasItem(BaseItems.IRON_ROD)).build(consumer,
            "mapperbase:steel_rod_from_blasting");

        // Metal plates
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.IRON_PLATE).addIngredient(Items.IRON_INGOT).addIngredient(BaseItems.FLATTER_HAMMER).addCriterion("has_iron_ingot",
            this.hasItem(Items.IRON_INGOT)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_PLATE).addIngredient(BaseItems.STEEL_INGOT).addIngredient(BaseItems.FLATTER_HAMMER).addCriterion("has_steel_ingot",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);

        // Nugget to ingot and vice-versa
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_INGOT).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseItems.STEEL_NUGGET).addCriterion("has_steel_nugget",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_NUGGET)).setGroup("steel_ingot").build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_NUGGET, 9).addIngredient(BaseItems.STEEL_INGOT).addCriterion("has_steel_ingot", this.hasItem(BaseItems.STEEL_INGOT)).build(consumer,
            "mapperbase:steel_nugget_from_ingot");

        // Ingot to block and vice-versa
        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseItems.STEEL_INGOT).addCriterion("has_steel_ingot",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_INGOT)).build(consumer);
        ShapelessRecipeBuilder.shapelessRecipe(BaseItems.STEEL_INGOT, 9).addIngredient(BaseBlocks.STEEL_BLOCK).addCriterion("has_steel_block", this.hasItem(BaseBlocks.STEEL_BLOCK)).setGroup(
            "steel_ingot").build(consumer, "mapperbase:steel_ingot_from_block");

        // Tools

        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_AXE).key('#', Items.STICK).key('X', BaseItems.STEEL_INGOT).patternLine("XX").patternLine("X#").patternLine(" #").addCriterion(
            "has_steel_ingot", this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_PICKAXE).key('#', Items.STICK).key('X', BaseItems.STEEL_INGOT).patternLine("XXX").patternLine(" # ").patternLine(" # ").addCriterion(
            "has_steel_ingot", this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SHOVEL).key('#', Items.STICK).key('X', BaseItems.STEEL_INGOT).patternLine("X").patternLine("#").patternLine("#").addCriterion(
            "has_steel_ingot", this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_SWORD).key('#', Items.STICK).key('X', BaseItems.STEEL_INGOT).patternLine("X").patternLine("X").patternLine("#").addCriterion("has_steel_ingot",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HOE).key('#', Items.STICK).key('X', BaseItems.STEEL_INGOT).patternLine("XX").patternLine(" #").patternLine(" #").addCriterion(
            "has_steel_ingot", this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);

        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_BOOTS).key('X', BaseItems.STEEL_INGOT).patternLine("X X").patternLine("X X").addCriterion("has_steel",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_CHESTPLATE).key('X', BaseItems.STEEL_INGOT).patternLine("X X").patternLine("XXX").patternLine("XXX").addCriterion("has_steel",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_HELMET).key('X', BaseItems.STEEL_INGOT).patternLine("XXX").patternLine("X X").addCriterion("has_steel",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);
        ShapedRecipeBuilder.shapedRecipe(BaseItems.STEEL_LEGGINGS).key('X', BaseItems.STEEL_INGOT).patternLine("XXX").patternLine("X X").patternLine("X X").addCriterion("has_steel",
            this.hasItem(BaseItems.STEEL_INGOT)).build(consumer);

        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_NUGGET, BaseItems.STEEL_PICKAXE, BaseItems.STEEL_SHOVEL, BaseItems.STEEL_AXE, BaseItems.STEEL_HOE, BaseItems.STEEL_SWORD,
            BaseItems.STEEL_HELMET, BaseItems.STEEL_CHESTPLATE, BaseItems.STEEL_LEGGINGS, BaseItems.STEEL_BOOTS, BaseItems.STEEL_HORSE_ARMOR), BaseItems.STEEL_NUGGET, 0.1F, 100).addCriterion(
                "has_iron_nugget", this.hasItem(Items.IRON_NUGGET)).addCriterion("has_steel_pickaxe", this.hasItem(BaseItems.STEEL_PICKAXE)).addCriterion("has_steel_shovel",
                    this.hasItem(BaseItems.STEEL_SHOVEL)).addCriterion("has_steel_axe", this.hasItem(BaseItems.STEEL_AXE)).addCriterion("has_steel_hoe",
                        this.hasItem(BaseItems.STEEL_HOE)).addCriterion("has_steel_sword", this.hasItem(BaseItems.STEEL_SWORD)).addCriterion("has_steel_helmet",
                            this.hasItem(BaseItems.STEEL_HELMET)).addCriterion("has_steel_chestplate", this.hasItem(BaseItems.STEEL_CHESTPLATE)).addCriterion("has_steel_leggings",
                                this.hasItem(BaseItems.STEEL_LEGGINGS)).addCriterion("has_steel_boots", this.hasItem(BaseItems.STEEL_BOOTS)).addCriterion("has_steel_horse_armor",
                                    this.hasItem(BaseItems.STEEL_HORSE_ARMOR)).build(consumer, "steel_nugget_from_blasting");

    }

}
