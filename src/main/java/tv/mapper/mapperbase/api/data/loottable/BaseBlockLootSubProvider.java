package tv.mapper.mapperbase.api.data.loottable;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.jetbrains.annotations.NotNull;

import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BaseBlockLootSubProvider extends BlockLootSubProvider
{
    // private String modid;
    private DeferredRegister.Blocks blockRegistry;

    protected BaseBlockLootSubProvider(Provider registries, DeferredRegister.Blocks blockRegistry)
    {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
        this.blockRegistry = blockRegistry;
    }

    @Override
    protected void generate()
    {}

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks()
    {
        // return BuiltInRegistries.BLOCK.stream().filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block)).filter(key ->
        // key.getNamespace().equals(modid)).isPresent()).collect(Collectors.toSet());

        List<Block> blocks = new ArrayList<Block>();

        for(DeferredHolder<Block, ? extends Block> object : blockRegistry.getEntries())
        {
            blocks.add(object.get());
        }

        return blocks;

        // return blocks.getEntries().toArray();

        // BuiltInRegistries.BLOCK.stream().filter(block -> Optional.of(BuiltInRegistries.BLOCK.getKey(block)).filter(key -> key.getNamespace().equals(modid)).isPresent()).collect(Collectors.toSet());
    }
}
