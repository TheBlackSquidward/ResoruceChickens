package io.github.TheBlackSquidward.resourcefulchickens.registries;

import io.github.TheBlackSquidward.resourcefulchickens.ResourcefulChickens;
import io.github.TheBlackSquidward.resourcefulchickens.common.containers.ChickenBreederContainer;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ContainerRegistry {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ResourcefulChickens.MODID);

    public static final RegistryObject<ContainerType<ChickenBreederContainer>> CHICKEN_BREEDER_CONTAINER = CONTAINERS.register("chicken_breeder", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.getEntityWorld();
        return new ChickenBreederContainer(windowId, world, pos, inv, inv.player);
    }));

}
