package tv.mapper.mapperbase.api.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile.UncheckedModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class BaseItemModelProvider extends ItemModelProvider
{
    private String name;

    public BaseItemModelProvider(PackOutput output, String modid, ExistingFileHelper existingFileHelper, String name)
    {
        super(output, modid, existingFileHelper);
        this.name = name;
    }

    @Override
    protected void registerModels()
    {}

    @Override
    public String getName()
    {
        return name;
    }

    /**
     * Creates a block item model and all the related blocks: slab, stairs, wall, pressure plate, fence, fence gate and button.
     */
    protected void registerBlockBasics(String name, boolean block, boolean slab, boolean stairs, boolean wall, boolean pressure, boolean fence, boolean fence_gate, boolean button)
    {
        if(block)
            simpleBlockItem(ResourceLocation.fromNamespaceAndPath(modid, name));
        if(slab)
            simpleBlockItem(ResourceLocation.fromNamespaceAndPath(modid, name + "_slab"));
        if(stairs)
            simpleBlockItem(ResourceLocation.fromNamespaceAndPath(modid, name + "_stairs"));
        if(wall)
            getBuilder(name + "_wall").parent(new UncheckedModelFile(modid + ":block/" + name + "_wall_inventory"));
        if(pressure)
            simpleBlockItem(ResourceLocation.fromNamespaceAndPath(modid, name + "_pressure_plate"));
        if(fence)
            getBuilder(name + "_fence").parent(new UncheckedModelFile(modid + ":block/" + name + "_fence_inventory"));
        if(fence_gate)
            simpleBlockItem(ResourceLocation.fromNamespaceAndPath(modid, name + "_fence_gate"));
        if(button)
            getBuilder(name + "_button").parent(new UncheckedModelFile(modid + ":block/" + name + "_button_inventory"));
    }
}
