package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.LadderBlock;
import net.minecraftforge.common.ToolType;

public class CustomLadderBlock extends LadderBlock
{
    protected ToolType toolType = null;

    public CustomLadderBlock(Properties properties)
    {
        super(properties);
    }

    public CustomLadderBlock(Properties properties, ToolType toolType)
    {
        super(properties);
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