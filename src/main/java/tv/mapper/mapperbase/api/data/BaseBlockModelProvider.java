package tv.mapper.mapperbase.api.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.BlockModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public abstract class BaseBlockModelProvider extends BlockModelProvider
{
    private String name;

    public BaseBlockModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper, String name)
    {
        super(output, modid, existingFileHelper);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    protected void buildWall(String name, ResourceLocation texture)
    {
        getBuilder(name + "_wall_inventory").parent(getExistingFile(mcLoc("block/wall_inventory"))).texture("wall", texture);
    }

    protected void buildFence(String name, ResourceLocation texture)
    {
        getBuilder(name + "_fence_inventory").parent(getExistingFile(mcLoc("block/fence_inventory"))).texture("texture", texture);
    }


    protected void buildButton(String name, ResourceLocation texture)
    {
        getBuilder(name + "_button_inventory").parent(getExistingFile(mcLoc("block/button_inventory"))).texture("texture", texture);
    }

    protected void buildRooftilesStairs(String name)
    {
        getBuilder(name + "_stairs").parent(getExistingFile(modLoc("block/rooftiles_stairs"))).texture("top", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)).texture("bottom", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)).texture("side", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)).texture("particle", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
        getBuilder(name + "_stairs_inner").parent(getExistingFile(modLoc("block/rooftiles_inner_stairs"))).texture("top", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_inner")).texture("bottom", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_inner")).texture("side", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)).texture("particle", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
        getBuilder(name + "_stairs_outer").parent(getExistingFile(modLoc("block/rooftiles_outer_stairs"))).texture("top", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_outer")).texture("bottom", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name + "_outer")).texture("side", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name)).texture("particle", ResourceLocation.fromNamespaceAndPath(modid, "block/" + name));
    }

}
