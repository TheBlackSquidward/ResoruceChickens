package io.github.TheBlackSquidward.resourcechickens.config;

import com.electronwill.nightconfig.core.file.CommentedFileConfig;
import com.electronwill.nightconfig.core.io.WritingMode;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;

public class ConfigHelper {

    public static void loadConfig(ForgeConfigSpec spec, Path path) {
        ResourceChickens.LOGGER.debug("Loading config file {}", path);

        final CommentedFileConfig configData = CommentedFileConfig.builder(path)
                .sync()
                .autosave()
                .writingMode(WritingMode.REPLACE)
                .build();

        ResourceChickens.LOGGER.debug("Built TOML config for {}", path.toString());
        configData.load();
        ResourceChickens.LOGGER.debug("Loaded TOML config file {}", path.toString());
        spec.setConfig(configData);
    }

}
