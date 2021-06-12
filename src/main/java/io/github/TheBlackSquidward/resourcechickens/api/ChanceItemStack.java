package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonObject;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;

import java.util.Random;

public class ChanceItemStack {

    private ItemStack stack;
    private Double chance;

    private final Random random = new Random();

    private ChanceItemStack(ItemStack stack, Double chance) {
        this.stack = stack;
        this.chance = chance;
    }

    public ChanceItemStack(ItemStack stack) {
        this.stack = stack;
        this.chance = 1.0;
    }

    public static ChanceItemStack of(ItemStack stack, Double chance) {
        return new ChanceItemStack(stack, chance);
    }

    public static ChanceItemStack of(ItemStack stack) {
        return new ChanceItemStack(stack);
    }

    public static ChanceItemStack of(Item item) {
        return new ChanceItemStack(new ItemStack(item));
    }

    public static ChanceItemStack of(Item item, int amount) {
        return new ChanceItemStack(new ItemStack(item, amount));
    }

    public static ChanceItemStack of(Item item, int amount, Double chance) {
        return new ChanceItemStack(new ItemStack(item, amount), chance);
    }

    public JsonObject toJSON() {
        JsonObject jsonobject = new JsonObject();
        jsonobject.addProperty("item", Registry.ITEM.getKey(stack.getItem()).toString());
        jsonobject.addProperty("amount", stack.getCount());
        jsonobject.addProperty("chance", chance);
        return jsonobject;
    }

    public static ChanceItemStack fromJSON(JsonObject jsonObject) {
        Item item = Registry.ITEM.get(new ResourceLocation(jsonObject.get("item").getAsString()));
        return ChanceItemStack.of(new ItemStack(item, jsonObject.get("amount").getAsInt()), jsonObject.get("chance").getAsDouble());
    }

    public static ChanceItemStack read(PacketBuffer buffer) {
        ItemStack stack = buffer.readItem();
        Double chance = buffer.readDouble();
        return ChanceItemStack.of(stack, chance);
    }

    public void write(PacketBuffer buffer) {
        buffer.writeItemStack(this.stack, false);
        buffer.writeDouble(this.chance);
    }

    public boolean roll() {
        return random.nextDouble() <= chance;
    }

    @Override
    public String toString() {
        return "ChancedItemStack{" + "stack=" + stack + ", chance=" + chance + '}';
    }

    public ItemStack getStack() {
        return stack;
    }

    public void setStack(ItemStack stack) {
        this.stack = stack;
    }

    public Double getChance() {
        return chance;
    }

    public void setChance(Double chance) {
        this.chance = chance;
    }
}
