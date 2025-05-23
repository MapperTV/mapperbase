package tv.mapper.mapperbase.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.MB_Blocks;

public class MB_CreativeTab
{
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MapperBase.MODID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> MAPPERBASE_TAB = CREATIVE_MODE_TABS.register("mapperbase_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.mapperbase")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> MB_Items.STEEL_INGOT.get().getDefaultInstance()).displayItems((parameters, output) ->
    {
        output.accept(MB_Blocks.STEEL_BLOCK.get());
        output.accept(MB_Blocks.STEEL_STAIRS.get());
        output.accept(MB_Blocks.STEEL_SLAB.get());
        output.accept(MB_Blocks.STEEL_WALL.get());
        output.accept(MB_Blocks.STEEL_PRESSURE_PLATE.get());
        output.accept(MB_Blocks.STEEL_FENCE.get());
        output.accept(MB_Blocks.STEEL_FENCE_GATE.get());
        output.accept(MB_Blocks.STEEL_BUTTON.get());
        output.accept(MB_Blocks.RAW_STEEL_BLOCK.get());

        output.accept(MB_Items.STEEL_INGOT.get());
        output.accept(MB_Items.STEEL_NUGGET.get());
        output.accept(MB_Items.RAW_STEEL.get());
        output.accept(MB_Items.PIG_IRON_CHUNK.get());
        output.accept(MB_Items.STEEL_ROD.get());
        output.accept(MB_Items.STEEL_PLATE.get());

        output.accept(MB_Items.STEEL_AXE.get());
        output.accept(MB_Items.STEEL_PICKAXE.get());
        output.accept(MB_Items.STEEL_SHOVEL.get());
        output.accept(MB_Items.STEEL_HOE.get());
        output.accept(MB_Items.STEEL_SWORD.get());
        output.accept(MB_Items.STEEL_HELMET.get());
        output.accept(MB_Items.STEEL_CHESTPLATE.get());
        output.accept(MB_Items.STEEL_LEGGINGS.get());
        output.accept(MB_Items.STEEL_BOOTS.get());

        output.accept(MB_Items.STEEL_HORSE_ARMOR.get());

        output.accept(MB_Items.RIVET.get());
        output.accept(MB_Items.FLATTER_HAMMER.get());
        output.accept(MB_Items.REINFORCED_FLATTER_HAMMER.get());
        output.accept(MB_Items.IRON_ROD.get());
        output.accept(MB_Items.IRON_PLATE.get());

    }).build());

}
