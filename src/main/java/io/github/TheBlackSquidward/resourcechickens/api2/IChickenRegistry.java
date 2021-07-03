package io.github.TheBlackSquidward.resourcechickens.api2;

import com.google.gson.JsonObject;

public interface IChickenRegistry {

    CustomChickenData getCustomChickenObject(String chickenName);

    JsonObject getRawCustomChickenObject(String chickenName);

    boolean canParentsBreed(String parent1, String parent2);

}
