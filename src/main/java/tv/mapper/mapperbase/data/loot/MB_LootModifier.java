package tv.mapper.mapperbase.data.loot;

import java.util.function.Supplier;

import com.google.common.base.Suppliers;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;

import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.common.loot.LootModifier;

public class MB_LootModifier extends LootModifier
{
    public static Supplier<MapCodec<MB_LootModifier>> CODEC_SUPPLIER = Suppliers.memoize(() -> RecordCodecBuilder.mapCodec(instance -> MB_LootModifier.codecStart(instance).and(BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(chestLootGeneratorInstance -> chestLootGeneratorInstance.item)).apply(instance, MB_LootModifier::new)));

    private final Item item;

    public MB_LootModifier(LootItemCondition[] conditionsIn, Item item)
    {
        super(conditionsIn);
        this.item = item;
    }

    @Override
    public MapCodec<? extends IGlobalLootModifier> codec()
    {
        return CODEC_SUPPLIER.get();
    }

    @Override
    protected ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context)
    {
        for(LootItemCondition condition : this.conditions)
        {
            if(!condition.test(context))
            {
                return generatedLoot;
            }
        }

        generatedLoot.add(new ItemStack(this.item));
        return generatedLoot;
    }

}
