package tv.mapper.mapperbase.block;

import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.ToolType;

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

    public PaintableBlock(Properties properties, ToolType toolType, int materialType)
    {
        super(properties, toolType);
        this.materialType = materialType;
    }

    public int getMaterialType()
    {
        return this.materialType;
    }

    @Override
    public ItemStack getItem(IBlockReader worldIn, BlockPos pos, BlockState state)
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