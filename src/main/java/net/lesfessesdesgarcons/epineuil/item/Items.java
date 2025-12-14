package net.lesfessesdesgarcons.epineuil.item;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.block.Blocks;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items
{
        public static final DeferredRegister<Item> ITEMS =
                DeferredRegister.create(ForgeRegistries.ITEMS, EpiNeuil.MOD_ID);

        public static final FoodProperties RAW_TENDER_FOOD = new FoodProperties.Builder()
        .nutrition(1)
        .saturationModifier(0.1F)
        .effect(new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F)
        .build();

    public static final RegistryObject<Item> TENDER =
            ITEMS.register("tender", () -> new Item(new Item.Properties()));

    public static final FoodProperties TENDER_FOOD = new FoodProperties.Builder()
                .nutrition(2)
                .saturationModifier(0.3F)
                .build();
    
        public static final RegistryObject<Item> POULYTE_BLOCK_ITEM = ITEMS.register("poulyte_block",
        () -> new BlockItem(Blocks.POULYTE_BLOCK.get(), new Item.Properties()));

    public static final RegistryObject<Item> BUCKET =
            ITEMS.register("bucket", () -> new Item(new Item.Properties()));

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

        public static final RegistryObject<Item> CHICKEN_HELMET =
                ITEMS.register("chicken_helmet", () -> new ModArmorItem(
                ArmorMaterials.CHICKEN_ARMOR,
                ArmorItem.Type.HELMET,
                new Item.Properties()));

        public static final RegistryObject<Item> CHICKEN_CHESTPLATE =
                ITEMS.register("chicken_chestplate", () -> new ArmorItem(
                ArmorMaterials.CHICKEN_ARMOR,
                ArmorItem.Type.CHESTPLATE,
                new Item.Properties()));

        public static final RegistryObject<Item> CHICKEN_LEGGINGS =
                ITEMS.register("chicken_leggings", () -> new ArmorItem(
                ArmorMaterials.CHICKEN_ARMOR,
                ArmorItem.Type.LEGGINGS,
                new Item.Properties()));

        public static final RegistryObject<Item> CHICKEN_BOOTS =
                ITEMS.register("chicken_boots", () -> new ArmorItem(
                ArmorMaterials.CHICKEN_ARMOR,
                ArmorItem.Type.BOOTS,
                new Item.Properties()));

        public static final RegistryObject<Item> PHOENIX_HELMET =
                ITEMS.register("phoenix_helmet", () -> new ModArmorItem(
                ArmorMaterials.PHOENIX_ARMOR,
                ArmorItem.Type.HELMET,
                new Item.Properties()));

        public static final RegistryObject<Item> PHOENIX_CHESTPLATE =
                ITEMS.register("phoenix_chestplate", () -> new ArmorItem(
                ArmorMaterials.PHOENIX_ARMOR,
                ArmorItem.Type.CHESTPLATE,
                new Item.Properties()));

        public static final RegistryObject<Item> PHOENIX_LEGGINGS =
                ITEMS.register("phoenix_leggings", () -> new ArmorItem(
                ArmorMaterials.PHOENIX_ARMOR,
                ArmorItem.Type.LEGGINGS,
                new Item.Properties()));

        public static final RegistryObject<Item> PHOENIX_BOOTS =
                ITEMS.register("phoenix_boots", () -> new ArmorItem(
                ArmorMaterials.PHOENIX_ARMOR,
                ArmorItem.Type.BOOTS,
                new Item.Properties()));

        public static void register(IEventBus eventBus)
        {
                ITEMS.register(eventBus);
        }
}
