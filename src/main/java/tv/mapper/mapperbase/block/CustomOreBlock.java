package tv.mapper.mapperbase.block;

import java.util.Random;

import javax.annotation.Nullable;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.BlockState;
import net.minecraft.block.OreBlock;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.common.ToolType;

public class CustomOreBlock extends OreBlock
{
    protected ToolType toolType = null;

    public CustomOreBlock(AbstractBlock.Properties properties, ToolType toolType)
    {
        super(properties);
        this.toolType = toolType;
    }

    @Override
    protected int getExperience(Random rand)
    {
        return this == BaseBlocks.BITUMEN_ORE.get() ? MathHelper.nextInt(rand, 0, 1) : 0;
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