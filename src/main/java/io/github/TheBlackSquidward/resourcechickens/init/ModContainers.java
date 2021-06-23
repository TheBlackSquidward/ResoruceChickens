package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.containers.*;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static final DeferredRegister<ContainerType<?>> CONTAINERS = DeferredRegister.create(ForgeRegistries.CONTAINERS, ResourceChickens.MODID);

    public static final RegistryObject<ContainerType<ChickenBreederContainer>> CHICKEN_BREEDER_CONTAINER = CONTAINERS.register("chicken_breeder", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new ChickenBreederContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<ElectricChickenBreederContainer>> ELECTRIC_CHICKEN_BREEDER_CONTAINER = CONTAINERS.register("electric_chicken_breeder", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new ElectricChickenBreederContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<ElectricRoostContainer>> ELECTRIC_ROOST_CONTAINER = CONTAINERS.register("roost", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new ElectricRoostContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<RoostContainer>> ROOST_CONTAINER = CONTAINERS.register("electric_roost", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new RoostContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<ElectricIncubatorContainer>> ELECTRIC_INCUBATOR_CONTAINER = CONTAINERS.register("electric_incubator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new ElectricIncubatorContainer(windowId, world, pos, inv, inv.player);
    }));
    public static final RegistryObject<ContainerType<IncubatorContainer>> INCUBATOR_CONTAINER = CONTAINERS.register("incubator", () -> IForgeContainerType.create((windowId, inv, data) -> {
        BlockPos pos = data.readBlockPos();
        World world = inv.player.level;
        return new IncubatorContainer(windowId, world, pos, inv, inv.player);
    }));

}
