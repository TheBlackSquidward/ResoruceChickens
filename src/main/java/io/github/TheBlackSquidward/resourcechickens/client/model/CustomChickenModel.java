package io.github.TheBlackSquidward.resourcechickens.client.model;

import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import net.minecraft.client.renderer.entity.model.ChickenModel;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class CustomChickenModel<T extends CustomChickenEntity> extends ChickenModel<T> {

}
