package tv.mapper.mapperbase.block;

import java.util.function.Supplier;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.StairsBlock;
import net.minecraftforge.common.ToolType;

public class CustomStairsBlock extends StairsBlock
{
    private ToolType toolType = null;

    public CustomStairsBlock(Supplier<BlockState> state, Properties properties)
    {
        super(state, properties);
    }

    public CustomStairsBlock(Supplier<BlockState> state, Properties properties, ToolType toolType)
    {
        super(state, properties);
        this.toolType = toolType;
    }

    @Nullable
    @Override
    public ToolType getHarvestTool(BlockState state)
    {
        if(toolType != null)
            return this.toolType;
        else
            return super.getHarvestTool(state);
    }

}
