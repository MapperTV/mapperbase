package tv.mapper.mapperbase.data;

import java.util.concurrent.CompletableFuture;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;
import tv.mapper.mapperbase.data.tags.MB_Tags;
import tv.mapper.mapperbase.item.MB_Items;

public class RecipeGenerator extends RecipeProvider
{

    public RecipeGenerator(PackOutput pOutput, CompletableFuture<Provider> pRegistries)
    {
        super(pOutput, pRegistries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output)
    {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.RIVET.get()).requires(MB_Tags.Items.NUGGET_STEEL).requires(MB_Tags.Items.FLATTER_HAMMERS).unlockedBy("has_steel_nugget", has(MB_Tags.Items.NUGGET_STEEL)).unlockedBy("has_flatter_hammer", has(MB_Tags.Items.FLATTER_HAMMERS)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MB_Items.FLATTER_HAMMER.get()).pattern("i").pattern("s").define('i', Tags.Items.INGOTS_IRON).define('s', Tags.Items.RODS_WOODEN).unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON)).unlockedBy("has_stick", has(Tags.Items.RODS_WOODEN)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MB_Items.REINFORCED_FLATTER_HAMMER.get()).pattern("i").pattern("s").define('i', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);

        // Steel processing
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(Tags.Items.INGOTS_IRON), RecipeCategory.MISC, MB_Items.PIG_IRON_CHUNK, 0.3f, 800).unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.RAW_STEEL).requires(MB_Items.PIG_IRON_CHUNK).requires(MB_Items.PIG_IRON_CHUNK).requires(MB_Items.PIG_IRON_CHUNK).requires(MB_Tags.Items.FLATTER_HAMMERS).unlockedBy("has_pig_iron_chunk", has(MB_Items.PIG_IRON_CHUNK)).unlockedBy("has_flatter_hammer", has(MB_Tags.Items.FLATTER_HAMMERS)).save(output);
        SimpleCookingRecipeBuilder.blasting(Ingredient.of(MB_Items.RAW_STEEL), RecipeCategory.MISC, MB_Items.STEEL_INGOT.get(), 1.0f, 800).unlockedBy("has_raw_steel", has(MB_Items.RAW_STEEL)).save(output, MapperBase.MODID + ":steel_ingot_from_raw_steel");

        // Steel material
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_BLOCK).pattern("aaa").pattern("aaa").pattern("aaa").define('a', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MB_Items.STEEL_INGOT.get()).pattern("aaa").pattern("aaa").pattern("aaa").define('a', MB_Tags.Items.NUGGET_STEEL).unlockedBy("has_steel_nugget", has(MB_Tags.Items.NUGGET_STEEL)).group("steel_ingot").save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.STEEL_INGOT.get(), 9).requires(MB_Blocks.STEEL_BLOCK).unlockedBy("has_steel_block", has(MB_Blocks.STEEL_BLOCK)).group("steel_ingot").save(output, MapperBase.MODID + ":steel_ingot_from_block");
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.STEEL_NUGGET, 9).requires(MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_STAIRS, 4).pattern("  a").pattern(" aa").pattern("aaa").define('a', MB_Tags.Items.BLOCK_STEEL).unlockedBy("has_steel_block", has(MB_Tags.Items.BLOCK_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_SLAB, 6).pattern("aaa").define('a', MB_Tags.Items.BLOCK_STEEL).unlockedBy("has_steel_block", has(MB_Tags.Items.BLOCK_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_WALL, 6).pattern("aaa").pattern("aaa").define('a', MB_Tags.Items.BLOCK_STEEL).unlockedBy("has_steel_block", has(MB_Tags.Items.BLOCK_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_PRESSURE_PLATE).pattern("aa").define('a', MB_Tags.Items.BLOCK_STEEL).unlockedBy("has_steel_block", has(MB_Tags.Items.BLOCK_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_FENCE, 3).pattern("bab").pattern("bab").define('a', MB_Tags.Items.ROD_STEEL).define('b', MB_Tags.Items.PLATE_STEEL).unlockedBy("has_steel_rod", has(MB_Tags.Items.ROD_STEEL)).unlockedBy("has_steel_plate", has(MB_Tags.Items.PLATE_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, MB_Blocks.STEEL_FENCE_GATE).pattern("aba").pattern("aba").define('a', MB_Tags.Items.ROD_STEEL).define('b', MB_Tags.Items.PLATE_STEEL).unlockedBy("has_steel_rod", has(MB_Tags.Items.ROD_STEEL)).unlockedBy("has_steel_plate", has(MB_Tags.Items.PLATE_STEEL)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Blocks.STEEL_BUTTON.get()).requires(MB_Tags.Items.PLATE_STEEL).unlockedBy("has_steel_plate", has(MB_Tags.Items.PLATE_STEEL)).save(output);

        // Steel gear
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MB_Items.STEEL_AXE).pattern("aa").pattern("as").pattern(" s").define('a', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MB_Items.STEEL_PICKAXE).pattern("aaa").pattern(" s ").pattern(" s ").define('a', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MB_Items.STEEL_SHOVEL).pattern("a").pattern("s").pattern("s").define('a', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, MB_Items.STEEL_HOE).pattern("aa").pattern(" s").pattern(" s").define('a', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MB_Items.STEEL_SWORD).pattern("a").pattern("a").pattern("s").define('a', MB_Tags.Items.INGOT_STEEL).define('s', MB_Tags.Items.ROD_IRON).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_iron_rod", has(MB_Tags.Items.ROD_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MB_Items.STEEL_HELMET).pattern("aaa").pattern("a a").define('a', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MB_Items.STEEL_CHESTPLATE).pattern("a a").pattern("aaa").pattern("aaa").define('a', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MB_Items.STEEL_LEGGINGS).pattern("aaa").pattern("a a").pattern("a a").define('a', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, MB_Items.STEEL_BOOTS).pattern("a a").pattern("a a").define('a', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);

        SimpleCookingRecipeBuilder.blasting(Ingredient.of(MB_Items.STEEL_PICKAXE, MB_Items.STEEL_SHOVEL, MB_Items.STEEL_AXE, MB_Items.STEEL_HOE, MB_Items.STEEL_SWORD, MB_Items.STEEL_HELMET, MB_Items.STEEL_CHESTPLATE, MB_Items.STEEL_LEGGINGS, MB_Items.STEEL_BOOTS), RecipeCategory.MISC, MB_Items.STEEL_NUGGET, 0.1f, 130).unlockedBy("has_steel_nugget", has(MB_Tags.Items.NUGGET_STEEL)).unlockedBy("has_steel_pickaxe", has(MB_Items.STEEL_PICKAXE)).unlockedBy("has_steel_shovel", has(MB_Items.STEEL_SHOVEL)).unlockedBy("has_steel_axe", has(MB_Items.STEEL_AXE)).unlockedBy("has_steel_hoe", has(MB_Items.STEEL_HOE)).unlockedBy("has_steel_sword", has(MB_Items.STEEL_SWORD)).unlockedBy("has_steel_helmet", has(MB_Items.STEEL_HELMET)).unlockedBy("has_steel_chestplate", has(MB_Items.STEEL_CHESTPLATE)).unlockedBy("has_steel_leggings", has(MB_Items.STEEL_LEGGINGS)).unlockedBy("has_steel_boots", has(MB_Items.STEEL_BOOTS)).save(output, MapperBase.MODID + ":steel_nugget_from_recycling");

        // Rods
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MB_Items.IRON_ROD.get(), 4).pattern("x").pattern("x").define('x', Tags.Items.INGOTS_IRON).unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON)).save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, MB_Items.STEEL_ROD.get(), 4).pattern("x").pattern("x").define('x', MB_Tags.Items.INGOT_STEEL).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).save(output);

        // Metal plates
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.IRON_PLATE.get()).requires(Tags.Items.INGOTS_IRON).requires(MB_Tags.Items.FLATTER_HAMMERS).unlockedBy("has_iron_ingot", has(Tags.Items.INGOTS_IRON)).unlockedBy("has_flatter_hammer", has(MB_Tags.Items.FLATTER_HAMMERS)).save(output);
        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, MB_Items.STEEL_PLATE.get()).requires(MB_Tags.Items.INGOT_STEEL).requires(MB_Tags.Items.FLATTER_HAMMERS).unlockedBy("has_steel_ingot", has(MB_Tags.Items.INGOT_STEEL)).unlockedBy("has_flatter_hammer", has(MB_Tags.Items.FLATTER_HAMMERS)).save(output);

    }

}

// iron + coal -BLAST> pig iron
// pig iron * 3 + flatter hammer = raw steel
// raw steel + coal -BLAST> steel
