package tv.mapper.mapperbase.api.data;

import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class BaseLanguageProvider extends LanguageProvider
{
    private String name;

    public BaseLanguageProvider(PackOutput output, String modid, String locale, String name)
    {
        super(output, modid, locale);
        this.name = name;
    }

    @Override
    public String getName()
    {
        return name;
    }

    @Override
    protected void addTranslations()
    {}

}
