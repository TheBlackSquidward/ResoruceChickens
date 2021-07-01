package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.DataGenerator;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ResourceChickensItemModelProvider extends ItemModelProvider {

    public ResourceChickensItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ResourceChickens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }

    public ItemModelBuilder simpleTexture(Item item, String texture) {
        return singleTexture(name(item), mcLoc("item/generated"), "layer0", modLoc(texture));
    }
    public ItemModelBuilder simpleTexture(Item item, ResourceLocation texture) {
        return singleTexture(name(item), mcLoc("item/generated"), texture);
    }
    public String name(Item item) {
        return item.getRegistryName().getPath();
    }

}
