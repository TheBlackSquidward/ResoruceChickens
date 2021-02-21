package io.github.TheBlackSquidward.resourcefulchickens.api.utils;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import net.minecraft.world.World;

public class MathHelper {

    public static int getRandomIntbyBounds(int minBound, int maxBound, World world) {
        return world.rand.nextInt((maxBound - minBound) + minBound) + 1;
    }

}
