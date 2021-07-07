package io.github.TheBlackSquidward.resourcechickens.api.data;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.registry.Registry;

import javax.annotation.Nullable;
import java.util.Optional;

public class ItemOutputData {

    public static final Codec<ItemOutputData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            Registry.ITEM.fieldOf("id").forGetter(ItemOutputData::getItem),
            Codec.INT.fieldOf("minAmount").orElse(1).forGetter(ItemOutputData::getMinAmount),
            Codec.INT.fieldOf("maxAmount").orElse(1).forGetter(ItemOutputData::getMaxAmount),
            CompoundNBT.CODEC.optionalFieldOf("nbt").forGetter((o) -> Optional.ofNullable(o.nbt))
    ).apply(instance, ItemOutputData::new));

    public ItemOutputData(Item item, int minAmount, int maxAmount, Optional<CompoundNBT> nbt) {
        this.item = item;
        this.minAmount = minAmount;
        this.maxAmount = maxAmount;
        nbt.ifPresent(this::setTag);
    }

    protected Item item;
    protected int minAmount;
    protected int maxAmount;
    protected CompoundNBT nbt;

    public Item getItem() {
        return item;
    }
    public int getMinAmount() {
        return minAmount;
    }
    public int getMaxAmount() {
        return maxAmount;
    }
    public CompoundNBT getNBT() {
        return nbt;
    }

    public int getDropAmount() {
        //TODO uniform distribution
        return 1;
    }

    public ItemStack getItemStack() {
        return new ItemStack(getItem(), getDropAmount(), getNBT());
    }

    public ItemStack getDisplayItem() {
        return new ItemStack(getItem(), 1);
    }

    public void setTag(@Nullable CompoundNBT pNbt) {
        this.nbt = pNbt;
    }

}
