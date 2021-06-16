package io.github.TheBlackSquidward.resourcechickens.datagen;

import io.github.TheBlackSquidward.resourcechickens.ResourceChickens;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ITag;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.ResourceLocation;

public class CustomTags {

    public static class Blocks {

        //public static final ITag.INamedTag<Block> BLOCKS_LEAD = forge("blocks/lead");

        private static ITag.INamedTag<Block> forge(String path) {
            return BlockTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Block> mod(String path) {
            return BlockTags.bind(new ResourceLocation(ResourceChickens.MODID, path).toString());
        }
    }
    public static class Items {

        public static final ITag.INamedTag<Item> RESOUCE_CHICKEN = mod("resource_chicken");
        public static final ITag.INamedTag<Item> RESOURCE_FEATHER = mod("resource_feather");
        public static final ITag.INamedTag<Item> EGG = mod("egg");

        private static ITag.INamedTag<Item> forge(String path) {
            return ItemTags.bind(new ResourceLocation("forge", path).toString());
        }

        private static ITag.INamedTag<Item> mod(String path) {
            return ItemTags.bind(new ResourceLocation(ResourceChickens.MODID, path).toString());
        }
    }

}
