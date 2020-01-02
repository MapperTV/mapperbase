package tv.mapper.mapperbase.data.gen;

import java.util.function.Consumer;

import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
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
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_INGOT), BaseItems.STEEL_INGOT, 1.0f, 120).addCriterion("has_iron_ingot", this.hasItem(Items.IRON_INGOT)).build(consumer);
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_BLOCK), BaseBlocks.STEEL_BLOCK, 1.0f, 120).addCriterion("has_iron_block", this.hasItem(Items.IRON_BLOCK)).build(consumer,
            "mapperbase:steel_block_from_blasting");

        ShapedRecipeBuilder.shapedRecipe(BaseBlocks.STEEL_BLOCK).patternLine("xxx").patternLine("xxx").patternLine("xxx").key('x', BaseItems.STEEL_INGOT).addCriterion("has_steel_ingot",
            InventoryChangeTrigger.Instance.forItems(BaseItems.STEEL_INGOT)).build(consumer);
    }

}
