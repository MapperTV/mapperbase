package tv.mapper.mapperbase.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import tv.mapper.mapperbase.MapperBase;

public class BlockModelGenerator extends BlockModelProvider
{
    public BlockModelGenerator(PackOutput output, ExistingFileHelper existingFileHelper)
    {
        super(output, MapperBase.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels()
    {
        getBuilder("steel_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", modLoc("block/steel_block"));
        getBuilder("steel_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", modLoc("block/steel_block"));
        getBuilder("steel_button_inventory").parent(getExistingFile(mcLoc("block/button_inventory"))).texture("texture", modLoc("block/steel_block"));
    }
}
