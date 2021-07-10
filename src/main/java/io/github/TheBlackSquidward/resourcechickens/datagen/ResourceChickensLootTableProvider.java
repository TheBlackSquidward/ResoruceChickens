package io.github.TheBlackSquidward.resourcechickens.datagen;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import io.github.TheBlackSquidward.resourcechickens.init.ModBlocks;
import io.github.TheBlackSquidward.resourcechickens.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.loot.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;
import org.jetbrains.annotations.NotNull;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

public class ResourceChickensLootTableProvider extends LootTableProvider {

    public ResourceChickensLootTableProvider(DataGenerator dataGenerator) {
        super(dataGenerator);
    }

    @Override
    protected @NotNull List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(Pair.of(Blocks::new, LootParameterSets.BLOCK));
    }

    @ParametersAreNonnullByDefault
    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((resourceLocation, lootTable) -> LootTableManager.validate(validationtracker, resourceLocation, lootTable));
    }

    public static final class Blocks extends ResourceChickensBlockLootTableProvider {
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.oakChickenBreeder);
            dropSelf(ModBlocks.darkOakChickenBreeder);
            dropSelf(ModBlocks.birchChickenBreeder);
            dropSelf(ModBlocks.spruceChickenBreeder);
            dropSelf(ModBlocks.acaciaChickenBreeder);
            dropSelf(ModBlocks.jungleChickenBreeder);
            dropSelf(ModBlocks.warpedChickenBreeder);
            dropSelf(ModBlocks.crimsonChickenBreeder);
            dropSelf(ModBlocks.poweredChickenBreeder);

            dropSelf(ModBlocks.oakRoost);
            dropSelf(ModBlocks.darkOakRoost);
            dropSelf(ModBlocks.birchRoost);
            dropSelf(ModBlocks.spruceRoost);
            dropSelf(ModBlocks.acaciaRoost);
            dropSelf(ModBlocks.jungleRoost);
            dropSelf(ModBlocks.warpedRoost);
            dropSelf(ModBlocks.crimsonRoost);
            dropSelf(ModBlocks.poweredRoost);

            dropSelf(ModBlocks.oakHenhouse);
            dropSelf(ModBlocks.darkOakHenhouse);
            dropSelf(ModBlocks.birchHenhouse);
            dropSelf(ModBlocks.spruceHenhouse);
            dropSelf(ModBlocks.acaciaHenhouse);
            dropSelf(ModBlocks.jungleHenhouse);
            dropSelf(ModBlocks.warpedHenhouse);
            dropSelf(ModBlocks.crimsonHenhouse);

            dropSelf(ModBlocks.roostController);
            dropSelf(ModBlocks.chickenBreederController);
            dropSelf(ModBlocks.industrialCasing);
            dropWithSilk(ModBlocks.industrialGlass, ModItems.industrialGlass);

            dropSelf(ModBlocks.poweredIncubator);
        }

        @Override
        protected @NotNull Iterable<Block> getKnownBlocks() {
            return ModBlocks.BLOCKS.getEntries().stream()
                    .map(RegistryObject::get)
                    .collect(Collectors.toList());
        }

    }


}
