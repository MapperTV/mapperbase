package tv.mapper.mapperbase.block;

import javax.annotation.Nullable;

import net.minecraft.block.BlockState;
import net.minecraft.block.PressurePlateBlock;
import net.minecraftforge.common.ToolType;

public class CustomPressurePlateBlock extends PressurePlateBlock
{
    private ToolType toolType = null;

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties)
    {
        super(sensitivity, properties);
    }

    public CustomPressurePlateBlock(Sensitivity sensitivity, Properties properties, ToolType toolType)
    {
        super(sensitivity, properties);
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
