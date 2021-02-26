package io.github.TheBlackSquidward.resourcechickens.registries;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.common.te.ChickenBreederTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityRegistry {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ResourceChickens.MODID);

    public static final RegistryObject<TileEntityType<ChickenBreederTE>> CHICKEN_BREEDER_TE = TILE_ENTITY.register("chicken_breeder", () -> TileEntityType.Builder.create(ChickenBreederTE::new, BlockRegistry.CHICKEN_BREEDER.get()).build(null));

}
