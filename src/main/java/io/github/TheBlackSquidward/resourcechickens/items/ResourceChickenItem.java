package io.github.TheBlackSquidward.resourcechickens.items;

import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.CustomChickenData;
import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import net.minecraftforge.common.util.Lazy;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class ResourceChickenItem extends ChickenItem{

    private final Lazy<? extends EntityType<?>> entityType;
    private final String chickenName;

    public ResourceChickenItem(RegistryObject<? extends EntityType<?>> entityTypeSupplier, String chickenName, Properties properties) {
        super(properties);
        this.chickenName = chickenName;
        this.entityType = Lazy.of(entityTypeSupplier);
    }

    public CustomChickenData getChickenData() {
        return ChickenRegistry.getChickenRegistry().getChickenData(chickenName);
    }

    @Override
    public @NotNull EntityType<?> getType(@Nullable CompoundNBT nbt) {
        return entityType.get();
    }

    public String getChickenName() {
        return chickenName;
    }

}
