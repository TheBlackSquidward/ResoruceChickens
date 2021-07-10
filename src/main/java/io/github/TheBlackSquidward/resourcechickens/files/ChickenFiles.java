package io.github.TheBlackSquidward.resourcechickens.files;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import com.mojang.serialization.Codec;
import com.mojang.serialization.JsonOps;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.files.config.Config;
import io.github.TheBlackSquidward.resourcechickens.utils.Constants;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nullable;
import java.io.File;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.util.Locale;
import java.util.function.BiConsumer;
import java.util.stream.Stream;

public class ChickenFiles {

    //TODO proof

    private static Path chickenPath;
    public static final String JSON = ".json";
    public static final Path MOD_ROOT = ModList.get().getModFileById(ResourceChickens.MOD_ID).getFile().getFilePath();
    public static final String defaultChickens = "/data/resourcechickens/chickens";

    public static void setChickenPath(Path path) {
        chickenPath = path;
    }

    public static void setupChickens() {
        if(Config.generateDefaultChickenFiles.get()) {
            copyDefaultChickens();
        }
        iterateFiles(chickenPath, ChickenFiles::parseChicken);
        ChickenRegistry.getChickenRegistry().regenerateCustomChickenData();
    }

    private static void copyDefaultChickens() {
        if (Files.isRegularFile(MOD_ROOT)) {
            try(FileSystem fileSystem = FileSystems.newFileSystem(MOD_ROOT, null)) {
                Path path = fileSystem.getPath(defaultChickens);
                if (Files.exists(path)) {
                    copyFiles(path, chickenPath);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (Files.isDirectory(MOD_ROOT)) {
            copyFiles(Paths.get(MOD_ROOT.toString(), defaultChickens), chickenPath);
        }
    }

    private static void copyFiles(Path source, Path targetPath) {
        try (Stream<Path> sourceStream = Files.walk(source)) {
            sourceStream.filter(f -> f.getFileName().toString().endsWith(JSON))
                    .forEach(path -> {
                        File targetFile = new File(String.valueOf(Paths.get(targetPath.toString(), "/", path.getFileName().toString())));
                        try {
                            Files.copy(path, targetFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parseChicken(Reader reader, String name) {
        JsonObject jsonObject = fromJson(Constants.ResourceChickens.GSON, reader, JsonObject.class);
        name = Codec.STRING.fieldOf("name").orElse(name).codec().fieldOf("coreData").codec().parse(JsonOps.INSTANCE, jsonObject).get().orThrow();
        ChickenRegistry.getChickenRegistry().addRawChickenData(name.toLowerCase(Locale.ENGLISH).replace(" ", "_"), jsonObject);
        ResourceChickens.LOGGER.info("Added " + name.toLowerCase(Locale.ENGLISH).replace(" ", "_") + " chicken to the chicken registry.");
    }

    private static void iterateFiles(Path chickenDir, BiConsumer<Reader, String> instructions) {
        try(Stream<Path> jsonStream = Files.walk(chickenDir)) {
            jsonStream.filter((f) -> f.getFileName().toString().endsWith(JSON)).forEach((path) -> addFile(path, instructions));
        }catch (IOException exception) {
            ResourceChickens.LOGGER.error(exception);
        }
    }

    private static void addFile(Path path, BiConsumer<Reader, String> instructions) {
        File f = path.toFile();
        try {
            parseType(f, instructions);
        } catch (IOException e) {
            ResourceChickens.LOGGER.warn("File not found: {}", path);
        }
    }

    private static void parseType(File file, BiConsumer<Reader, String> consumer) throws IOException {
        String name = file.getName();
        name = name.substring(0, name.indexOf('.'));
        Reader r = Files.newBufferedReader(file.toPath());
        consumer.accept(r, name);
    }

    @Nullable
    public static <T> T fromJson(Gson gson, Reader reader, Class<T> class_, boolean bl) {
        try {
            JsonReader jsonReader = new JsonReader(reader);
            jsonReader.setLenient(bl);
            return gson.getAdapter(class_).read(jsonReader);
        } catch (IOException var5) {
            throw new JsonParseException(var5);
        }
    }
    @Nullable
    public static <T> T fromJson(Gson gson, Reader reader, Class<T> class_) {
        return fromJson(gson, reader, class_, false);
    }

}
