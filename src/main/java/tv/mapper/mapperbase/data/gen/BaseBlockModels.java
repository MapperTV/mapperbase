package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.client.model.generators.ExistingFileHelper;

public class BaseBlockModels extends BlockModelProvider
{
    public BaseBlockModels(DataGenerator generator, String modid, ExistingFileHelper existingFileHelper)
    {
        super(generator, modid, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "Mapper Base Block Models";
    }

    @Override
    protected void registerModels()
    {
        getBuilder("steel_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", modLoc("block/steel_block"));
        getBuilder("steel_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/steel_block"));
        getBuilder("steel_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/steel_block"));
        getBuilder("steel_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", modLoc("block/steel_block"));

        getBuilder("concrete_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", modLoc("block/concrete"));
        getBuilder("concrete_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/concrete"));
        getBuilder("concrete_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/concrete"));
        getBuilder("concrete_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", modLoc("block/concrete"));

        getBuilder("asphalt_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", modLoc("block/asphalt"));
        getBuilder("asphalt_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", modLoc("block/asphalt"));
    }

    protected void buildWall(String name, ResourceLocation texture) // Trump's favorite model generator
    {
        getBuilder(name + "_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", texture);
    }

    protected void buildFence(String name, ResourceLocation texture)
    {
        getBuilder(name + "_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", texture);
    }

    protected void buildPressure(String name, ResourceLocation texture)
    {
        getBuilder(name + "_pressure_plate").parent(getExistingFile(mcLoc("block/pressure_plate_up"))).texture("texture", texture);
        getBuilder(name + "_pressure_plate_down").parent(getExistingFile(mcLoc("block/pressure_plate_down"))).texture("texture", texture);
    }

    protected void buildButton(String name, ResourceLocation texture)
    {
        getBuilder(name + "_button_inventory").parent(getExistingFile(mcLoc("block/button_inventory"))).texture("texture", texture);
        getBuilder(name + "_button_pressed").parent(getExistingFile(mcLoc("block/button_pressed"))).texture("texture", texture);
        getBuilder(name + "_button").parent(getExistingFile(mcLoc("block/button"))).texture("texture", texture);
    }
}
