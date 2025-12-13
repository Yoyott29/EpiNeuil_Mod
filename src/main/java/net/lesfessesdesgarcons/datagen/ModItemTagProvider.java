package net.lesfessesdesgarcons.datagen;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.item.Items;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import java.util.concurrent.CompletableFuture;

import javax.annotation.Nullable;

public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput packOutput, CompletableFuture<HolderLookup.Provider> completableFuture,
        CompletableFuture<TagLookup<Block>> lookupCompletableFuture, @Nullable ExistingFileHelper existingFileHelper) {
        super(packOutput, completableFuture, lookupCompletableFuture, EpiNeuil.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        tag(ItemTags.TRIMMABLE_ARMOR)
            .add(Items.CHICKEN_HELMET.get())
            .add(Items.CHICKEN_CHESTPLATE.get())
            .add(Items.CHICKEN_LEGGINGS.get())
            .add(Items.CHICKEN_BOOTS.get());
    }
}