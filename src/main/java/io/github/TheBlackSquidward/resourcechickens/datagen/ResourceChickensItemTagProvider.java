package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ResourceChickensItemTagProvider extends ItemTagsProvider {

    public ResourceChickensItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, ResourceChickens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        ChickenRegistry.getChickenRegistry().getChickens().forEach((chickenName, customChickenData) -> {
            tag(ResourceChickensTags.Items.RESOUCE_CHICKEN).add(customChickenData.getChickenItem().getItem());
            if(customChickenData.getCoreData().hasFeather()) {
                tag(ResourceChickensTags.Items.RESOURCE_FEATHER).add(customChickenData.getChickenFeather().getItem());
            }
        });
    }
}
