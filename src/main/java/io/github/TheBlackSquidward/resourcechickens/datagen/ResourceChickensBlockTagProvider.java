package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ResourceChickensBlockTagProvider extends BlockTagsProvider {

    public ResourceChickensBlockTagProvider(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, ResourceChickens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
    }
}
