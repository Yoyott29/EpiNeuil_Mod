package net.lesfessesdesgarcons.epineuil.sounds;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EpiNeuil.MOD_ID);

    public static final RegistryObject<SoundEvent> breakingblock = registerSoundEvent("breakingblock");
    public static final RegistryObject<SoundEvent> MUSIC = registerSoundEvent("music");
    public static final RegistryObject<SoundEvent> PHOENIX_ARMOR = registerSoundEvent("phoenix_armor");
    public static final RegistryObject<SoundEvent> tender_cooked = registerSoundEvent("tender_cooked");
    public static final RegistryObject<SoundEvent> ho_le_poulet = registerSoundEvent("ho_le_poulet");

    private static RegistryObject<SoundEvent> registerSoundEvent(String name) {
    return SOUNDS_EVENTS.register(name, () -> 
        (SoundEvent) SoundEvent.createVariableRangeEvent(
            ResourceLocation.fromNamespaceAndPath(EpiNeuil.MOD_ID, name)
        )
    );
}

    public static void register(IEventBus eventBus) {
        SOUNDS_EVENTS.register(eventBus);
    }
}

