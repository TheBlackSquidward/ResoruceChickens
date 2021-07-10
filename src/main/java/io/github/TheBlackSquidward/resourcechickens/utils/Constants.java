package io.github.TheBlackSquidward.resourcechickens.utils;

import com.google.gson.Gson;

public class Constants {

    public static class ResourceChickens {

        public static final Gson GSON = new Gson();
    }

    public static class NBT {
        public static final String INVENTORY = "inventory";

        public static final String GROWTH = "growth";
        public static final String GAIN = "gain";
        public static final String STRENGTH = "strength";
    }

    public static class JSON {
        public static final String INPUT = "input";
        public static final String OUTPUT = "output";
        public static final String ITEM = "item";
        public static final String COUNT = "count";
        public static final String NBT = "nbt";
        public static final String TAG = "tag";
        public static final String CHANCE = "chance";

        public static final String TOTAL_BREED_TIME = "totalBreedTime";
        public static final String TOTAL_ROOST_TIME = "totalRoostTime";
    }

}
