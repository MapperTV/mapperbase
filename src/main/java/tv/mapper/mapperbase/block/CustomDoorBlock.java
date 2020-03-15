package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.DoorBlock;
import net.minecraftforge.common.ToolType;

public class CustomDoorBlock extends DoorBlock
{
    protected ToolType toolType = null;

    public CustomDoorBlock(Properties builder)
    {
        super(builder);
    }

    public CustomDoorBlock(Properties builder, ToolType toolType)
    {
        super(builder);
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