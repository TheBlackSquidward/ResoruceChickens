package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.data.BreedData;
import io.github.TheBlackSquidward.resourcechickens.api.data.CoreData;
import io.github.TheBlackSquidward.resourcechickens.api.data.RoostData;
import net.minecraft.item.ItemStack;

public interface IResourceChicken {

    String getChickenName();

    JsonObject getRawChickenData();

    CoreData getCoreData();

    BreedData getBreedData();

    RoostData getRoostData();

}
