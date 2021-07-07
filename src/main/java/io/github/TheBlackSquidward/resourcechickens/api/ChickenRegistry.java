package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonObject;
import com.mojang.serialization.JsonOps;
import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;

import java.util.*;

public class ChickenRegistry implements IChickenRegistry{

    private static final Map<String, JsonObject> rawChickenData = new LinkedHashMap<>();
    private static final Map<String, CustomChickenData> chickenData = new LinkedHashMap<>();
    private static final ChickenRegistry chickenRegistry = new ChickenRegistry();

    public static ChickenRegistry getChickenRegistry() {
        return chickenRegistry;
    }

    public static boolean containsChicken(String chickenName) {
        return chickenData.containsKey(chickenName);
    }

    public CustomChickenData getChickenData(String chickenName) {
        return chickenData.getOrDefault(chickenName, CustomChickenData.DEFAULT);
    }

    public JsonObject getRawCustomChickenObject(String chickenName) {
        return rawChickenData.get(chickenName);
    }

    public boolean canParentsBreed(String parent1, String parent2) {
        //TODO
        return false;
    }

    public Map<String, CustomChickenData> getChickens() {
        return Collections.unmodifiableMap(chickenData);
    }

    public void regenerateCustomChickenData() {
        rawChickenData.forEach((chickenName, rawChickenData) -> chickenData.compute(chickenName, (s, customChickenDataCodec) ->
                CustomChickenData.CODEC(s).parse(JsonOps.INSTANCE, rawChickenData)
                        .getOrThrow(false, s2 -> ResourceChickens.LOGGER.error("Could not create Custom Chicken Data for {} chicken", s))));
    }

    public void addRawChickenData(String chickenType, JsonObject chickenData) {
        rawChickenData.computeIfAbsent(chickenType.toLowerCase(Locale.ENGLISH).replace(" ", "_"), s -> Objects.requireNonNull(chickenData));
    }
}
