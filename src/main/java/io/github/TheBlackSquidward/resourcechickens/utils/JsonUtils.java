package io.github.TheBlackSquidward.resourcechickens.utils;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.item.ItemStack;

public class JsonUtils {

    public static JsonElement serializeItemStack(ItemStack stack) {
        JsonObject json = new JsonObject();
        json.addProperty(Constants.JSON.ITEM, stack.getItem().getRegistryName().toString());
        if (stack.getCount() > 1) {
            json.addProperty(Constants.JSON.COUNT, stack.getCount());
        }
        if (stack.hasTag()) {
            json.addProperty(Constants.JSON.NBT, stack.getTag().toString());
        }
        return json;
    }

}
