package tv.mapper.mapperbase.block;

import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

/*
 *  PaintableBlock
 *  
 *  This class is like a regular block, except that it can be painted when Road Stuff is loaded.
 *  If Road Stuff isn't loaded then nothing special happens, it's just a regular block.
 *  
 */
public class PaintableBlock extends CustomBlock
{
    protected int materialType = 0;

    public PaintableBlock(Properties properties, int materialType)
    {
        super(properties);
        this.materialType = materialType;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state)
    {
        switch(materialType)
        {
            case 0:
                return new ItemStack(BaseBlocks.ASPHALT.get());
            case 1:
                return new ItemStack(BaseBlocks.CONCRETE.get());
            default:
                return null;
        }
    }
}