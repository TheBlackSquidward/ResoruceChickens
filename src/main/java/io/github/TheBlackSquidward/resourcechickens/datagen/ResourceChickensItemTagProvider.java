package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.utils.ChickenRegistryObject;
import io.github.TheBlackSquidward.resourcechickens.init.ModChickens;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.fml.RegistryObject;

public class ResourceChickensItemTagProvider extends ItemTagsProvider {

    public ResourceChickensItemTagProvider(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, ResourceChickens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (RegistryObject<ChickenRegistryObject> chickenObject : ModChickens.CHICKENS.getEntries()) {
            tag(ResourceChickensTags.Items.RESOUCE_CHICKEN).add(chickenObject.get().getChickenItemRegistryObject().get());
            if(chickenObject.get().isHasFeather()) {
                tag(ResourceChickensTags.Items.RESOURCE_FEATHER).add(chickenObject.get().getChickenFeatherItem());
            }
        }
    }
}
