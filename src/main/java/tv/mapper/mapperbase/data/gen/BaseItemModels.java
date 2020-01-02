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
        getBuilder("steel_ingot").parent(new UncheckedModelFile("item/generated")).texture("layer0", modLoc("item/steel_ingot"));
    }

}
