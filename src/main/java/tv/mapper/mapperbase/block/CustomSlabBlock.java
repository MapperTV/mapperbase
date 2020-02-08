package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.SlabBlock;
import net.minecraftforge.common.ToolType;

public class CustomSlabBlock extends SlabBlock
{
    private ToolType toolType = null;

    public CustomSlabBlock(Properties properties)
    {
        super(properties);
    }

    public CustomSlabBlock(Properties properties, ToolType toolType)
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
