package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.*;

public interface IResourceChicken {

    String getChickenName();

    JsonObject getRawChickenData();

    CoreData getCoreData();

    RenderData getRenderData();

    BreedData getBreedData();

    RoostData getRoostData();

    SpawnData getSpawnData();

}
