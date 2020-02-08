package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.WallBlock;
import net.minecraftforge.common.ToolType;

public class CustomWallBlock extends WallBlock
{
    private ToolType toolType = null;

    public CustomWallBlock(Properties properties)
    {
        super(properties);
    }

    public CustomWallBlock(Properties properties, ToolType toolType)
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
