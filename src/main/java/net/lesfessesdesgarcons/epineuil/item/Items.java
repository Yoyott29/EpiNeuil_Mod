package net.lesfessesdesgarcons.epineuil.item;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items
{
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, EpiNeuil.MOD_ID);

    public static final RegistryObject<Item> TENDER =
            ITEMS.register("tender", () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> BUCKET =
            ITEMS.register("bucket", () -> new Item(new Item.Properties()));

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

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
