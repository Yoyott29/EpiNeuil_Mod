package net.lesfessesdesgarcons.epineuil.item;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class Items
{
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, EpiNeuil.MOD_ID);

        public static final FoodProperties RAW_TENDER_FOOD = new FoodProperties.Builder()
        .nutrition(1)
        .saturationModifier(0.1F)
        .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
        .build();

        public static final FoodProperties TENDER_FOOD = new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.3F)
                .build();

        public static final FoodProperties BUCKET_FOOD = new FoodProperties.Builder()
                .nutrition(6)
                .saturationModifier(0.8F)
                .build();

        public static final RegistryObject<Item> RAW_TENDER =
        ITEMS.register("raw_tender", () -> new Item(new Item.Properties()
                .food(RAW_TENDER_FOOD)));

        public static final RegistryObject<Item> TENDER_PIECE =
                ITEMS.register("tender_piece", () -> new Item(new Item.Properties()
                        .food(TENDER_FOOD)));

        public static final RegistryObject<Item> TENDER_BUCKET =
                ITEMS.register("tender_bucket", () ->
                new Item(new Item.Properties().food(BUCKET_FOOD)));

        public static void register(IEventBus eventBus) {
                ITEMS.register(eventBus);
        }
}
