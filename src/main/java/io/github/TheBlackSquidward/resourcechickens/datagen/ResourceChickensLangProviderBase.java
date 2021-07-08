package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.fml.RegistryObject;

public abstract class ResourceChickensLangProviderBase extends LanguageProvider {

    public ResourceChickensLangProviderBase(DataGenerator dataGenerator) {
        super(dataGenerator, ResourceChickens.MOD_ID, "en_us");
    }

    public void addBlock(RegistryObject<Block> key, String name) {
        add(key.get().getDescriptionId(), name);
    }

    public void addItem(RegistryObject<Item> key, String name) {
        add(key.get().getDescriptionId(), name);
    }
}
