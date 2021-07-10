package io.github.TheBlackSquidward.resourcechickens.files.config;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.common.ForgeConfigSpec.*;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class Config {

    public static BooleanValue generateDefaultChickenFiles;

    public static class CommonConfig {
        public static final Path PATH = FMLPaths.CONFIGDIR.get().resolve("resourcechickens.toml");
        public static final ForgeConfigSpec commonConfig;
        static {
            Builder commonConfigBuidler = new Builder();

            commonConfigBuidler.push("Mod Options");
            generateDefaultChickenFiles = commonConfigBuidler.comment("\n Set to false to disable the generation of default chicken files.").define("generateDefaultChickenFiles", true);
            commonConfigBuidler.pop();

            commonConfig = commonConfigBuidler.build();
        }
    }

    public static class ClientConfig {
        public static final ForgeConfigSpec clientConfig;
        static {
            Builder clientConfigBuidler = new Builder();



            clientConfig = clientConfigBuidler.build();
        }
    }

}
