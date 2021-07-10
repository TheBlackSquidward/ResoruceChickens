package io.github.TheBlackSquidward.resourcechickens.entities;

import com.google.gson.JsonObject;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import io.github.TheBlackSquidward.resourcechickens.api.IResourceChicken;
import io.github.TheBlackSquidward.resourcechickens.api.data.chickenData.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.ChickenEntity;
import net.minecraft.world.World;

public class CustomChickenEntity extends ChickenEntity implements IResourceChicken {

    protected final CustomChickenData customChickenData;
    protected final String chickenName;

    public CustomChickenEntity(EntityType<? extends ChickenEntity> type, World worldIn, String chickenName) {
        super(type, worldIn);
        this.chickenName = chickenName;
        this.customChickenData = ChickenRegistry.getChickenRegistry().getChickenData(chickenName);
    }

    public CustomChickenData getCustomChickenData() {
        return customChickenData;
    }
    public String getChickenName() {
        return chickenName;
    }
    public JsonObject getRawChickenData() {
        return customChickenData.getRawData();
    }
    public CoreData getCoreData() {
        return customChickenData.getCoreData();
    }
    public RenderData getRenderData() {
        return customChickenData.getRenderData();
    }
    public BreedData getBreedData() {
        return customChickenData.getBreedData();
    }
    public RoostData getRoostData() {
        return customChickenData.getRoostData();
    }
    public SpawnData getSpawnData() {
        return customChickenData.getSpawnData();
    }

    @Override
    public boolean canFallInLove() {
        return false;
    }

}
