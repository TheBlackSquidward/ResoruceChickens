package io.github.TheBlackSquidward.resourcechickens.init;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.common.te.ChickenBreederTE;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityInit {

    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, ResourceChickens.MODID);

    public static final RegistryObject<TileEntityType<ChickenBreederTE>> CHICKEN_BREEDER_TE = TILE_ENTITY.register("chicken_breeder", () -> TileEntityType.Builder.create(ChickenBreederTE::new, BlockInit.CHICKEN_BREEDER.get()).build(null));

}
