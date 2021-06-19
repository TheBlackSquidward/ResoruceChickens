package io.github.TheBlackSquidward.resourcechickens.config;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraftforge.fml.loading.FMLPaths;

import java.io.IOException;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileHelper {

    public static void setupPaths() {
        Path configPath = FMLPaths.CONFIGDIR.get();
        Path chickenDir = Paths.get(configPath.toAbsolutePath().toString(), ResourceChickens.MODID, "chickens");
        try { Files.createDirectories(chickenDir);
        } catch (FileAlreadyExistsException ignored) { //ignored
        } catch (IOException e) { ResourceChickens.LOGGER.error("failed to create \"chickens\" directory");}
    }

}
