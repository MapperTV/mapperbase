package tv.mapper.mapperbase.world.item;
//package tv.mapper.mapperbase.item;
//
//import java.util.function.Supplier;
//
//import net.minecraft.util.LazyLoadedValue;
//import net.minecraft.world.item.Tier;
//import net.minecraft.world.item.crafting.Ingredient;
//import tv.mapper.mapperbase.data.BaseTags;
//
//@SuppressWarnings("deprecation")
//public enum BaseItemTier implements Tier
//{
//    STEEL(2, 768, 7.0F, 2.0F, 12, () ->
//    {
//        return Ingredient.of(BaseTags.ForgeItems.INGOTS_STEEL);
//    });
//
//    private final int harvestLevel;
//    private final int maxUses;
//    private final float efficiency;
//    private final float attackDamage;
//    private final int enchantability;
//    private final LazyLoadedValue<Ingredient> repairMaterial;
//
//    private BaseItemTier(int harvestLevelIn, int maxUsesIn, float efficiencyIn, float attackDamageIn, int enchantabilityIn, Supplier<Ingredient> repairMaterialIn)
//    {
//        this.harvestLevel = harvestLevelIn;
//        this.maxUses = maxUsesIn;
//        this.efficiency = efficiencyIn;
//        this.attackDamage = attackDamageIn;
//        this.enchantability = enchantabilityIn;
//        this.repairMaterial = new LazyLoadedValue<>(repairMaterialIn);
//    }
//
//    public int getUses()
//    {
//        return this.maxUses;
//    }
//
//    public float getSpeed()
//    {
//        return this.efficiency;
//    }
//
//    public float getAttackDamageBonus()
//    {
//        return this.attackDamage;
//    }
//
//    public int getLevel()
//    {
//        return this.harvestLevel;
//    }
//
//    public int getEnchantmentValue()
//    {
//        return this.enchantability;
//    }
//
//    public Ingredient getRepairIngredient()
//    {
//        return this.repairMaterial.get();
//    }
//}