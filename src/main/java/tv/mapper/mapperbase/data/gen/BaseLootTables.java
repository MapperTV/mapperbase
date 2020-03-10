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
        lootTables.put(BaseBlocks.STEEL_BLOCK.get(), createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_BLOCK.get()));
        lootTables.put(BaseBlocks.STEEL_SLAB.get(), createSlabTable(MapperBase.MODID, BaseBlocks.STEEL_SLAB.get()));
        lootTables.put(BaseBlocks.STEEL_STAIRS.get(), createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_STAIRS.get()));
        lootTables.put(BaseBlocks.STEEL_WALL.get(), createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_WALL.get()));
        lootTables.put(BaseBlocks.STEEL_PRESSURE_PLATE.get(), createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_PRESSURE_PLATE.get()));
        lootTables.put(BaseBlocks.STEEL_FENCE.get(), createStandardTable(MapperBase.MODID, BaseBlocks.STEEL_FENCE.get()));
        lootTables.put(BaseBlocks.CONCRETE.get(), createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE.get()));
        lootTables.put(BaseBlocks.CONCRETE_SLAB.get(), createSlabTable(MapperBase.MODID, BaseBlocks.CONCRETE_SLAB.get()));
        lootTables.put(BaseBlocks.CONCRETE_STAIRS.get(), createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_STAIRS.get()));
        lootTables.put(BaseBlocks.CONCRETE_WALL.get(), createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_WALL.get()));
        lootTables.put(BaseBlocks.CONCRETE_PRESSURE_PLATE.get(), createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_PRESSURE_PLATE.get()));
        lootTables.put(BaseBlocks.CONCRETE_FENCE.get(), createStandardTable(MapperBase.MODID, BaseBlocks.CONCRETE_FENCE.get()));
    }
}