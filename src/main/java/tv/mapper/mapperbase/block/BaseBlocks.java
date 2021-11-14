package tv.mapper.mapperbase.block;

import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fmllegacy.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import tv.mapper.mapperbase.MapperBase;

public class BaseBlocks
{
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MapperBase.MODID);

    private static Properties steelProperties = Block.Properties.of(Material.METAL, MaterialColor.STONE).strength(5.0F, 6.0F).sound(SoundType.LANTERN).requiresCorrectToolForDrops();
    private static Properties concreteProperties = Block.Properties.of(Material.STONE, MaterialColor.STONE).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();
    private static Properties asphaltProperties = Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(1.5F, 6.0F).sound(SoundType.STONE).requiresCorrectToolForDrops();

    public static final RegistryObject<CustomBlock> STEEL_BLOCK = BLOCKS.register("steel_block", () -> new CustomBlock(steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomStairsBlock> STEEL_STAIRS = BLOCKS.register("steel_stairs", () -> new CustomStairsBlock(() -> STEEL_BLOCK.get().defaultBlockState(), steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomSlabBlock> STEEL_SLAB = BLOCKS.register("steel_slab", () -> new CustomSlabBlock(steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomWallBlock> STEEL_WALL = BLOCKS.register("steel_wall", () -> new CustomWallBlock(steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomPressurePlateBlock> STEEL_PRESSURE_PLATE = BLOCKS.register("steel_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, steelProperties.noCollission(), ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomFenceBlock> STEEL_FENCE = BLOCKS.register("steel_fence", () -> new CustomFenceBlock(steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));
    public static final RegistryObject<CustomFenceGateBlock> STEEL_FENCE_GATE = BLOCKS.register("steel_fence_gate", () -> new CustomFenceGateBlock(steelProperties, ToolTypes.PICKAXE, ToolTiers.IRON));

    public static final RegistryObject<PaintableBlock> CONCRETE = BLOCKS.register("concrete", () -> new PaintableBlock(concreteProperties, ToolTypes.PICKAXE, 1));
    public static final RegistryObject<CustomStairsBlock> CONCRETE_STAIRS = BLOCKS.register("concrete_stairs", () -> new CustomStairsBlock(() -> CONCRETE.get().defaultBlockState(), concreteProperties, ToolTypes.PICKAXE, ToolTiers.WOOD));
    public static final RegistryObject<CustomSlabBlock> CONCRETE_SLAB = BLOCKS.register("concrete_slab", () -> new CustomSlabBlock(concreteProperties, ToolTypes.PICKAXE, ToolTiers.WOOD));
    public static final RegistryObject<CustomWallBlock> CONCRETE_WALL = BLOCKS.register("concrete_wall", () -> new CustomWallBlock(concreteProperties, ToolTypes.PICKAXE));
    public static final RegistryObject<CustomPressurePlateBlock> CONCRETE_PRESSURE_PLATE = BLOCKS.register("concrete_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, concreteProperties.noCollission(), ToolTypes.PICKAXE));
    public static final RegistryObject<CustomFenceBlock> CONCRETE_FENCE = BLOCKS.register("concrete_fence", () -> new CustomFenceBlock(concreteProperties, ToolTypes.PICKAXE, ToolTiers.WOOD));
    public static final RegistryObject<CustomFenceGateBlock> CONCRETE_FENCE_GATE = BLOCKS.register("concrete_fence_gate", () -> new CustomFenceGateBlock(concreteProperties, ToolTypes.PICKAXE, ToolTiers.IRON));

    public static final RegistryObject<PaintableBlock> ASPHALT = BLOCKS.register("asphalt", () -> new PaintableBlock(asphaltProperties, ToolTypes.PICKAXE, 0));
    public static final RegistryObject<CustomStairsBlock> ASPHALT_STAIRS = BLOCKS.register("asphalt_stairs", () -> new CustomStairsBlock(() -> ASPHALT.get().defaultBlockState(), asphaltProperties, ToolTypes.PICKAXE, ToolTiers.WOOD));
    public static final RegistryObject<CustomSlabBlock> ASPHALT_SLAB = BLOCKS.register("asphalt_slab", () -> new CustomSlabBlock(asphaltProperties, ToolTypes.PICKAXE, ToolTiers.WOOD));
    public static final RegistryObject<CustomPressurePlateBlock> ASPHALT_PRESSURE_PLATE = BLOCKS.register("asphalt_pressure_plate", () -> new CustomPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, asphaltProperties.noCollission(), ToolTypes.PICKAXE));

    public static final RegistryObject<CustomBlock> BITUMEN_BLOCK = BLOCKS.register("bitumen_block", () -> new CustomBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F).requiresCorrectToolForDrops(), ToolTypes.PICKAXE));
    public static final RegistryObject<CustomOreBlock> BITUMEN_ORE = BLOCKS.register("bitumen_ore", () -> new CustomOreBlock(Block.Properties.of(Material.STONE, MaterialColor.COLOR_BLACK).strength(3.0F).requiresCorrectToolForDrops(), UniformInt.of(0, 1), ToolTypes.PICKAXE));

    public static void init()
    {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }
}