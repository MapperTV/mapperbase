package tv.mapper.mapperbase.block;

import net.minecraft.core.BlockPos;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CustomOreBlock extends OreBlock implements ToolType
{
    private ToolTiers tier;
    private ToolTypes tool;
    private UniformInt xpRange;

    public CustomOreBlock(Properties properties, UniformInt xpRange, ToolTypes tool)
    {
        super(properties);
        this.tool = tool;
        this.tier = ToolTiers.WOOD;
        this.xpRange = xpRange;
    }

    public CustomOreBlock(Properties properties, UniformInt xpRange, ToolTypes tool, ToolTiers tier)
    {
        super(properties);
        this.tool = tool;
        this.tier = tier;
        this.xpRange = xpRange;
    }

    @Override
    public ToolTiers getTier()
    {
        return this.tier;
    }

    @Override
    public ToolTypes getTool()
    {
        return this.tool;
    }

    @Override
    public int getExpDrop(BlockState state, LevelReader reader, BlockPos pos, int fortune, int silktouch)
    {
        return silktouch == 0 ? this.xpRange.sample(RANDOM) : 0;
    }
}