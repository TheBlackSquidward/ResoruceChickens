package io.github.TheBlackSquidward.resourcechickens.api;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.IItemProvider;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ChanceItemStackList {

    private final List<ChanceItemStack> chanceItemStackList;
    private List<ItemStack> cachedOutput;

    public ChanceItemStackList(ChanceItemStack... chanceItemStack) {
        this.chanceItemStackList = new ArrayList<>();
        this.cachedOutput = new ArrayList<>();
        this.chanceItemStackList.addAll(Arrays.asList(chanceItemStack));
        reloadCache();
    }

    public void addChanceItemStack(ChanceItemStack chanceItemStack) {
        this.chanceItemStackList.add(chanceItemStack);
    }

    public static ChanceItemStackList of(ChanceItemStack... stacks) {
        return new ChanceItemStackList(stacks);
    }

    public static ChanceItemStackList of(ItemStack... stacks) {
        return new ChanceItemStackList(Arrays.stream(stacks)
                .map(ChanceItemStack::of)
                .toArray(ChanceItemStack[]::new));
    }

    public static ChanceItemStackList of(IItemProvider... items) {
        return new ChanceItemStackList(Arrays.stream(items)
                .map(ItemStack::new)
                .map(ChanceItemStack::of)
                .toArray(ChanceItemStack[]::new));
    }

    public JsonArray toJSON() {
        JsonArray jsonArray = new JsonArray();
        for (ChanceItemStack stack : chanceItemStackList) {
            jsonArray.add(stack.toJSON());
        }
        return jsonArray;
    }

    public static ChanceItemStackList fromJSON(JsonArray jsonArray) {
        List<ChanceItemStack> list = new ArrayList<>();
        for (JsonElement element : jsonArray) {
            list.add(ChanceItemStack.fromJSON(element.getAsJsonObject()));
        }
        return new ChanceItemStackList(list.toArray(new ChanceItemStack[0]));
    }

    public static ChanceItemStackList read(PacketBuffer buffer) {
        int length = buffer.readInt();
        List<ChanceItemStack> list = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            list.add(ChanceItemStack.read(buffer));
        }
        return ChanceItemStackList.of(list.toArray(new ChanceItemStack[0]));
    }

    public void write(PacketBuffer buffer) {
        buffer.writeInt(chanceItemStackList.size());
        for (ChanceItemStack stack : chanceItemStackList) {
            stack.write(buffer);
        }
    }

    public void reloadCache() {
        cachedOutput = new ArrayList<>();
        for (ChanceItemStack stack : chanceItemStackList) {
            if (stack.roll()) {
                cachedOutput.add(stack.getStack().copy());
            }
        }
    }

    public List<ItemStack> dissolve() {
        return chanceItemStackList.stream().map(ChanceItemStack::getStack).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ChancedItemStackList{" + "stackList=" + chanceItemStackList + ", cachedOutput=" + cachedOutput + '}';
    }

}
