package tv.mapper.mapperbase.data.gen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ExistingFileHelper;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile.UncheckedModelFile;
import tv.mapper.mapperbase.MapperBase;

public class BaseItemModels extends ItemModelProvider
{
    public BaseItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper)
    {
        super(generator, MapperBase.MODID, existingFileHelper);
    }

    @Override
    public String getName()
    {
        return "Mapper Base Item Models";
    }

    @Override
    protected void registerModels()
    {
        getBuilder("flatter_hammer").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/flatter_hammer"));
        getBuilder("steel_nugget").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_nugget"));
        getBuilder("steel_ingot").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_ingot"));
        getBuilder("steel_plate").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_plate"));
        getBuilder("steel_rod").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_rod"));

        getBuilder("iron_plate").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/iron_plate"));
        getBuilder("iron_rod").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/iron_rod"));

        getBuilder("bolt").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/bolt"));

        getBuilder("steel_block").parent(new UncheckedModelFile(modid + ":block/steel_block"));
    }

}
