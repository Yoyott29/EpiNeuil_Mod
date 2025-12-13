package net.lesfessesdesgarcons.epineuil.item;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
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

    public static void register(IEventBus eventBus)
    {
        ITEMS.register(eventBus);
    }
}
