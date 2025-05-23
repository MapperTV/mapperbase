package tv.mapper.mapperbase.block;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.api.block.CustomBlock;
import tv.mapper.mapperbase.api.block.CustomButtonBlock;
import tv.mapper.mapperbase.api.block.CustomFenceBlock;
import tv.mapper.mapperbase.api.block.CustomFenceGateBlock;
import tv.mapper.mapperbase.api.block.CustomPressurePlateBlock;
import tv.mapper.mapperbase.api.block.CustomSlabBlock;
import tv.mapper.mapperbase.api.block.CustomStairBlock;
import tv.mapper.mapperbase.api.block.CustomWallBlock;
import tv.mapper.mapperbase.api.block.tools.ToolTiers;
import tv.mapper.mapperbase.api.block.tools.ToolTypes;

public class MB_Blocks
{
    static Properties METAL_PROPERTIES = BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).destroyTime(1.5f).explosionResistance(1.5f).requiresCorrectToolForDrops().sound(SoundType.LANTERN);

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(MapperBase.MODID);
    public static final DeferredRegister.Items BLOCK_ITEMS = DeferredRegister.createItems(MapperBase.MODID);

    public static final DeferredBlock<CustomBlock> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new CustomBlock(METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_BLOCK_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_block", STEEL_BLOCK);
    public static final DeferredBlock<CustomStairBlock> STEEL_STAIRS = BLOCKS.register("steel_stairs", () -> new CustomStairBlock(STEEL_BLOCK.get().defaultBlockState(), METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_STAIRS_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_stairs", STEEL_STAIRS);
    public static final DeferredBlock<CustomSlabBlock> STEEL_SLAB = BLOCKS.register("steel_slab", () -> new CustomSlabBlock(METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_SLAB_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_slab", STEEL_SLAB);
    public static final DeferredBlock<CustomWallBlock> STEEL_WALL = BLOCKS.register("steel_wall", () -> new CustomWallBlock(METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_WALL_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_wall", STEEL_WALL);
    public static final DeferredBlock<CustomPressurePlateBlock> STEEL_PRESSURE_PLATE = BLOCKS.register("steel_pressure_plate", () -> new CustomPressurePlateBlock(BlockSetType.IRON, METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_PRESSURE_PLATE_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_pressure_plate", STEEL_PRESSURE_PLATE);
    public static final DeferredBlock<CustomFenceBlock> STEEL_FENCE = BLOCKS.register("steel_fence", () -> new CustomFenceBlock(METAL_PROPERTIES, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_FENCE_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_fence", STEEL_FENCE);
    public static final DeferredBlock<CustomFenceGateBlock> STEEL_FENCE_GATE = BLOCKS.register("steel_fence_gate", () -> new CustomFenceGateBlock(METAL_PROPERTIES, SoundEvents.IRON_TRAPDOOR_OPEN, SoundEvents.IRON_TRAPDOOR_CLOSE, ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> STEEL_FENCE_GATE_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_fence_gate", STEEL_FENCE_GATE);
    public static final DeferredBlock<CustomButtonBlock> STEEL_BUTTON = BLOCKS.register("steel_button", () -> new CustomButtonBlock(BlockSetType.IRON, 20, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).sound(SoundType.LANTERN).noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), ToolTypes.PICKAXE));
    public static final DeferredItem<BlockItem> STEEL_BUTTON_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("steel_button", STEEL_BUTTON);
    public static final DeferredBlock<CustomBlock> RAW_STEEL_BLOCK = BLOCKS.register("raw_steel_block", () -> new CustomBlock(Block.Properties.of().sound(SoundType.DEEPSLATE).mapColor(MapColor.COLOR_GRAY).strength(1.5F, 6.0F), ToolTypes.PICKAXE, ToolTiers.STONE));
    public static final DeferredItem<BlockItem> RAW_STEEL_BLOCK_ITEM = BLOCK_ITEMS.registerSimpleBlockItem("raw_steel_block", RAW_STEEL_BLOCK);

}
