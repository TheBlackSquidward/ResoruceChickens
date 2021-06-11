package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagGenerator extends BlockTagsProvider {

    public BlockTagGenerator(DataGenerator dataGenerator, ExistingFileHelper existingFileHelper) {
        super(dataGenerator, ResourceChickens.MODID, existingFileHelper);
    }

    @Override
    protected void addTags() {
    }
}
