package io.github.TheBlackSquidward.resourcechickens.items;

import net.minecraft.entity.EntityType;
import net.minecraft.nbt.CompoundNBT;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class VanillaChickenItem extends ChickenItem{

    public VanillaChickenItem(Properties properties) {
        super(properties);
    }

    @Override
    public @NotNull EntityType<?> getType(@Nullable CompoundNBT nbt) {
        return EntityType.CHICKEN;
    }

}
