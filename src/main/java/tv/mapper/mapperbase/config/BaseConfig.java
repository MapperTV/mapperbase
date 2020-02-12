package tv.mapper.mapperbase.config;

import org.apache.commons.lang3.tuple.Pair;

import net.minecraftforge.common.ForgeConfigSpec;

public class BaseConfig
{
    public static final ClientConfig CLIENT;
    public static final ForgeConfigSpec CLIENT_CONFIG;

    static
    {
        final Pair<ClientConfig, ForgeConfigSpec> specPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);

        CLIENT = specPair.getLeft();
        CLIENT_CONFIG = specPair.getRight();
    }

    public static class ClientConfig
    {
        public static ForgeConfigSpec.BooleanValue ENABLE_TAG_VIEWER;

        ClientConfig(ForgeConfigSpec.Builder CLIENT_BUILDER)
        {
            CLIENT_BUILDER.comment("Mapper Base General Config").push("general_config");
            ENABLE_TAG_VIEWER = CLIENT_BUILDER.comment("Enable the Tag Viewer (press CTRL while cursor being on item). This is client-side only. [default: false]").define("EnableTagViewer", false);
            CLIENT_BUILDER.pop();
        }
    }
}
