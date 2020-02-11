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
    }
}