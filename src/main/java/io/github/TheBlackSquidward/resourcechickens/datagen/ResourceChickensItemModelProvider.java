package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import io.github.TheBlackSquidward.resourcechickens.api.ChickenRegistry;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ResourceChickensItemModelProvider extends ItemModelProvider {

    public ResourceChickensItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, ResourceChickens.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        ChickenRegistry.getChickenRegistry().getChickens().forEach((chickenName, customChickenData) -> spawnEggBuidler(chickenName + "_chicken_spawn_egg"));
    }

    public void spawnEggBuidler(String name) {
        getBuilder(name).parent(getExistingFile(mcLoc("item/generated")))
                .texture("layer0", modLoc("items/spawn_egg"))
                .texture("layer1", modLoc("items/spawn_egg_overlay"));
    }

}
