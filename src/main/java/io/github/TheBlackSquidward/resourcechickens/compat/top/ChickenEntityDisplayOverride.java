package io.github.TheBlackSquidward.resourcechickens.compat.top;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.entities.CustomChickenEntity;
import mcjty.theoneprobe.api.IEntityDisplayOverride;
import mcjty.theoneprobe.api.IProbeHitEntityData;
import mcjty.theoneprobe.api.IProbeInfo;
import mcjty.theoneprobe.api.ProbeMode;
import net.minecraft.block.FurnaceBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public class ChickenEntityDisplayOverride implements IEntityDisplayOverride {

    @Override
    public boolean overrideStandardInfo(ProbeMode probeMode, IProbeInfo iProbeInfo, PlayerEntity playerEntity, World world, Entity entity, IProbeHitEntityData iProbeHitEntityData) {
        return entity instanceof CustomChickenEntity && createChickenProbeData(iProbeInfo, (CustomChickenEntity) entity, probeMode);
    }

    private boolean createChickenProbeData(IProbeInfo probeInfo, CustomChickenEntity customChickenEntity, ProbeMode mode) {
        ChickenRegistryObject chickenRegistryObject = ChickenRegistry.getChickenRegistryObjectbyEntity(customChickenEntity);
        probeInfo.horizontal()
                .entity(customChickenEntity)
                .vertical()
                .itemLabel(chickenRegistryObject.buildChickenStack())
                .text(TopCompat.formattedName);
        if(mode.equals(ProbeMode.EXTENDED)) {

        }
        return true;
    }

}
