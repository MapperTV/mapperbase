package tv.mapper.mapperbase.item;

import java.util.List;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class BaseTiers
{
    public static final Tag.Named<Block> NEEDS_STEEL_TOOL = BlockTags.createOptional(new ResourceLocation("forge:needs_steel_tool"));
    public static final Tier STEEL_TIER = TierSortingRegistry.registerTier(new ForgeTier(2, 768, 7.0F, 2.0F, 12, NEEDS_STEEL_TOOL, () -> Ingredient.of(BaseItems.STEEL_INGOT.get())), new ResourceLocation("forge:steel"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));
}