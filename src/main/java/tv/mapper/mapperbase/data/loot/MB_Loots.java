package tv.mapper.mapperbase.data.loot;

import com.mojang.serialization.MapCodec;

import net.neoforged.neoforge.common.loot.IGlobalLootModifier;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;
import tv.mapper.mapperbase.MapperBase;

public class MB_Loots
{
    public static DeferredRegister<MapCodec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(NeoForgeRegistries.GLOBAL_LOOT_MODIFIER_SERIALIZERS, MapperBase.MODID);

    public static final DeferredHolder<MapCodec<? extends IGlobalLootModifier>, MapCodec<MB_LootModifier>> ADD_ITEM_MODIFIER = LOOT_MODIFIERS.register("add_item", MB_LootModifier.CODEC_SUPPLIER);
}
