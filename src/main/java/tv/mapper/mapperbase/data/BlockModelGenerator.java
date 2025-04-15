package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.api.data.BaseBlockModelProvider;

public class BlockModelGenerator extends BaseBlockModelProvider
{
    public BlockModelGenerator(PackOutput output, String modid, ExistingFileHelper existingFileHelper, String name)
    {
        super(output, modid, existingFileHelper, name);
    }

    @Override
    protected void registerModels()
    {
        buildWall("steel", modLoc("block/steel_block"));
        buildFence("steel", modLoc("block/steel_block"));
        buildButton("steel", modLoc("block/steel_block"));
    }
}
