package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;

public class BaseLootTables extends BaseLootTableProvider
{

    public BaseLootTables(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }

    @Override
    protected void addTables()
    {
        lootTables.put(BaseBlocks.STEEL_BLOCK, createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_BLOCK));
        lootTables.put(BaseBlocks.STEEL_SLAB, createSlabTable(MapperBase.MODID, BaseBlocks.STEEL_SLAB));
        lootTables.put(BaseBlocks.STEEL_STAIRS, createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_STAIRS));
        lootTables.put(BaseBlocks.STEEL_WALL, createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_WALL));
        lootTables.put(BaseBlocks.STEEL_PRESSURE_PLATE, createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_PRESSURE_PLATE));
        lootTables.put(BaseBlocks.STEEL_FENCE, createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_FENCE));
        lootTables.put(BaseBlocks.CONCRETE, createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE));
        lootTables.put(BaseBlocks.CONCRETE_SLAB, createSlabTable(MapperBase.MODID, BaseBlocks.CONCRETE_SLAB));
        lootTables.put(BaseBlocks.CONCRETE_STAIRS, createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_STAIRS));
        lootTables.put(BaseBlocks.CONCRETE_WALL, createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_WALL));
        lootTables.put(BaseBlocks.CONCRETE_PRESSURE_PLATE, createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_PRESSURE_PLATE));
    }
}