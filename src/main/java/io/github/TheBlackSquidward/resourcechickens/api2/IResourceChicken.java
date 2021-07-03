package io.github.TheBlackSquidward.resourcechickens.api2;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api2.data.BreedData;
import io.github.TheBlackSquidward.resourcechickens.api2.data.CoreData;
import io.github.TheBlackSquidward.resourcechickens.api2.data.RoostData;

public interface IResourceChicken {

    String getChickenName();

    JsonObject getRawChickenData();

    CoreData getCoreData();

    BreedData getBreedData();

    RoostData getRoostData();



}
