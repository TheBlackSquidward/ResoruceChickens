package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.client.render.RoostTileEntityRenderer;
import io.github.TheBlackSquidward.resourcechickens.te.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ResourceChickens.MODID);

    public static final RegistryObject<TileEntityType<ChickenBreederTE>> CHICKEN_BREEDER_TE = TILE_ENTITY.register("chicken_breeder", () -> TileEntityType.Builder.of(ChickenBreederTE::new, BlockInit.CHICKEN_BREEDER.get()).build(null));
    public static final RegistryObject<TileEntityType<ElectricChickenBreederTE>> ELECTRIC_CHICKEN_BREEDER_TE = TILE_ENTITY.register("electric_chicken_breeder", () -> TileEntityType.Builder.of(ElectricChickenBreederTE::new, BlockInit.ELECTRIC_CHICKEN_BREEDER.get()).build(null));
    public static final RegistryObject<TileEntityType<ElectricRoostTE>> ELECTRIC_ROOST_TE = TILE_ENTITY.register("electric_roost", () -> TileEntityType.Builder.of(ElectricRoostTE::new, BlockInit.ELECTRIC_ROOST.get()).build(null));
    public static final RegistryObject<TileEntityType<RoostTE>> ROOST_TE = TILE_ENTITY.register("roost", () -> TileEntityType.Builder.of(RoostTE::new, BlockInit.ROOST.get()).build(null));
    public static final RegistryObject<TileEntityType<ElectricIncubatorTE>> ELECTRIC_INCUBATOR_TE = TILE_ENTITY.register("electric_incubator", () -> TileEntityType.Builder.of(ElectricIncubatorTE::new, BlockInit.ELECTRIC_INCUBATOR.get()).build(null));
    public static final RegistryObject<TileEntityType<IncubatorTE>> INCUBATOR_TE = TILE_ENTITY.register("incubator", () -> TileEntityType.Builder.of(IncubatorTE::new, BlockInit.INCUBATOR.get()).build(null));

    public static void registerTileEntityRenders() {
        ClientRegistry.bindTileEntityRenderer(TileEntityInit.ROOST_TE.get(), RoostTileEntityRenderer::new);
    }
}
