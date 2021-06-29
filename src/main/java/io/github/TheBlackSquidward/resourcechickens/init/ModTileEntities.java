package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.client.render.RoostTileEntityRenderer;
import io.github.TheBlackSquidward.resourcechickens.te.*;
import io.github.TheBlackSquidward.resourcechickens.te.chicken_breeder.*;
import io.github.TheBlackSquidward.resourcechickens.te.roost.*;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ResourceChickens.MODID);

    //Chicken Breeders
    public static final RegistryObject<TileEntityType<OakChickenBreederTE>> oakChickenBreeder = TILE_ENTITY.register("oak_chicken_breeder", () -> TileEntityType.Builder.of(OakChickenBreederTE::new, ModBlocks.oakChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<DarkOakChickenBreederTE>> darkOakChickenBreeder = TILE_ENTITY.register("dark_oak_chicken_breeder", () -> TileEntityType.Builder.of(DarkOakChickenBreederTE::new, ModBlocks.darkOakChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<BirchChickenBreederTE>> birchChickenBreeder = TILE_ENTITY.register("birch_chicken_breeder", () -> TileEntityType.Builder.of(BirchChickenBreederTE::new, ModBlocks.birchChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<SpruceChickenBreederTE>> spruceChickenBreeder = TILE_ENTITY.register("spruce_chicken_breeder", () -> TileEntityType.Builder.of(SpruceChickenBreederTE::new, ModBlocks.spruceChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<AcaciaChickenBreederTE>> acaciaChickenBreeder = TILE_ENTITY.register("acacia_chicken_breeder", () -> TileEntityType.Builder.of(AcaciaChickenBreederTE::new, ModBlocks.acaciaChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<JungleChickenBreederTE>> jungleChickenBreeder = TILE_ENTITY.register("jungle_chicken_breeder", () -> TileEntityType.Builder.of(JungleChickenBreederTE::new, ModBlocks.jungleChickenBreeder.get()).build(null));
    public static final RegistryObject<TileEntityType<PowererdChickenBreederTE>> poweredChickenBreeder = TILE_ENTITY.register("electric_chicken_breeder", () -> TileEntityType.Builder.of(PowererdChickenBreederTE::new, ModBlocks.poweredChickenBreeder.get()).build(null));

    //Roosts
    public static final RegistryObject<TileEntityType<OakRoostTE>> oakRoost = TILE_ENTITY.register("oak_roost", () -> TileEntityType.Builder.of(OakRoostTE::new, ModBlocks.oakRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<DarkOakRoostTE>> darkOakRoost = TILE_ENTITY.register("dark_oak_roost", () -> TileEntityType.Builder.of(DarkOakRoostTE::new, ModBlocks.darkOakRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<BirchRoostTE>> birchRoost = TILE_ENTITY.register("birch_roost", () -> TileEntityType.Builder.of(BirchRoostTE::new, ModBlocks.birchRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<SpruceRoostTE>> spruceRoost = TILE_ENTITY.register("spruce_roost", () -> TileEntityType.Builder.of(SpruceRoostTE::new, ModBlocks.spruceRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<AcaciaRoostTE>> acaciaRoost = TILE_ENTITY.register("acacia_roost", () -> TileEntityType.Builder.of(AcaciaRoostTE::new, ModBlocks.acaciaRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<JungleRoostTE>> jungleRoost = TILE_ENTITY.register("jungle_roost", () -> TileEntityType.Builder.of(JungleRoostTE::new, ModBlocks.jungleRoost.get()).build(null));
    public static final RegistryObject<TileEntityType<PoweredRoostTE>> poweredRoost = TILE_ENTITY.register("powered_roost", () -> TileEntityType.Builder.of(PoweredRoostTE::new, ModBlocks.poweredRoost.get()).build(null));

    public static final RegistryObject<TileEntityType<ElectricIncubatorTE>> poweredIncubator = TILE_ENTITY.register("electric_incubator", () -> TileEntityType.Builder.of(ElectricIncubatorTE::new, ModBlocks.ELECTRIC_INCUBATOR.get()).build(null));
    public static final RegistryObject<TileEntityType<IncubatorTE>> incuabtor = TILE_ENTITY.register("incubator", () -> TileEntityType.Builder.of(IncubatorTE::new, ModBlocks.INCUBATOR.get()).build(null));

    public static void registerTileEntityRenderers() {
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.oakRoost.get(), RoostTileEntityRenderer::new);
        ClientRegistry.bindTileEntityRenderer(ModTileEntities.darkOakRoost.get(), RoostTileEntityRenderer::new);
    }

}
