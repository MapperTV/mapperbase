package tv.mapper.mapperbase.data.gen;

import java.util.function.Consumer;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.Ingredient;
import tv.mapper.mapperbase.item.BaseItems;

public class Recipes extends RecipeProvider
{
    public Recipes(DataGenerator generatorIn)
    {
        super(generatorIn);
    }

    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        CookingRecipeBuilder.blastingRecipe(Ingredient.fromItems(Items.IRON_INGOT), BaseItems.STEEL_INGOT, 1.0f, 120).addCriterion("has_iron_ingot", this.hasItem(Items.IRON_INGOT)).build(consumer,
            "steel_ingot");
    }

}
