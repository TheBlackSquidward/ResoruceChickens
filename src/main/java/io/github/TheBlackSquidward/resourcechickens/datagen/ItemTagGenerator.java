package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistryObject;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTagGenerator extends ItemTagsProvider {

    public ItemTagGenerator(DataGenerator dataGenerator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, blockTagsProvider, ResourceChickens.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        for (ChickenRegistryObject chickenRegistryObject : ChickenRegistry.getChickenRegistry()) {
            tag(CustomTags.Items.RESOUCE_CHICKEN).add(chickenRegistryObject.getChickenItemRegistryObject().get());
            if(chickenRegistryObject.isHasFeather()) {
                tag(CustomTags.Items.RESOURCE_FEATHER).add(chickenRegistryObject.getChickenFeatherItem());
            }
        }
    }
}
