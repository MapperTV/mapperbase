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
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_NUGGET), BaseItems.STEEL_NUGGET, 0.1f, 20).addCriterion("has_iron_nugget", this.hasItem(Items.IRON_NUGGET)).build(consumer,
            "mapperbase:steel_nugget_from_blasting");
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

    }

}
