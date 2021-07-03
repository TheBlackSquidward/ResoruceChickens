package io.github.TheBlackSquidward.resourcechickens.api2;

import com.google.gson.JsonObject;

import java.util.Map;

public interface IChickenRegistry {

    CustomChickenData getChickenData(String chickenName);

    JsonObject getRawCustomChickenObject(String chickenName);

    boolean canParentsBreed(String parent1, String parent2);

    public Map<String, CustomChickenData> getChickens();

}
