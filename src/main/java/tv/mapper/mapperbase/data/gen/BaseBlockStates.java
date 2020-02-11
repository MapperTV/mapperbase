package tv.mapper.mapperbase.data.gen;

import net.minecraft.block.SlabBlock;
import net.minecraft.block.StairsBlock;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;
import tv.mapper.mapperbase.block.BaseBlocks;

public class BaseBlockStates extends BlockStateProvider
{

    public BaseBlockStates(DataGenerator gen, ExistingFileHelper exFileHelper)
    {
        super(gen, MapperBase.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels()
    {
        simpleBlock(BaseBlocks.STEEL_BLOCK);
        slabBlock((SlabBlock)BaseBlocks.STEEL_SLAB, modLoc("block/steel_block"), modLoc("block/steel_slab_side"), modLoc("block/steel_block"), modLoc("block/steel_block"));
        stairsBlock((StairsBlock)BaseBlocks.STEEL_STAIRS, modLoc("block/steel_block"), modLoc("block/steel_block"), modLoc("block/steel_block"));
    }
}
