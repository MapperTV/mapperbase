package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
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
        lootTables.put(BaseBlocks.STEEL_BLOCK, createStandardTable("steel_block", BaseBlocks.STEEL_BLOCK));
    }
}