package tv.mapper.mapperbase.block;

import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

public class CustomOreBlock extends OreBlock
{
    public CustomOreBlock(BlockBehaviour.Properties properties)
    {
        super(properties);
    }

    // @Override
    // protected int xpOnDrop(Random rand)
    // {
    // return this == BaseBlocks.BITUMEN_ORE.get() ? Mth.nextInt(rand, 0, 1) : 0;
    // }
}