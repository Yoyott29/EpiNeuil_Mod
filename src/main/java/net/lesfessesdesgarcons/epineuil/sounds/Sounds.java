package net.lesfessesdesgarcons.epineuil.sounds;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Sounds {

    public static final DeferredRegister<SoundEvent> SOUNDS_EVENTS =
            DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, EpiNeuil.MOD_ID);

    public static final RegistryObject<SoundEvent> FART = registerSoundEvent("fart");
    public static final RegistryObject<SoundEvent> STEP = registerSoundEvent("step");
    public static final RegistryObject<SoundEvent> PLACE = registerSoundEvent("place");
    public static final RegistryObject<SoundEvent> HIT = registerSoundEvent("hit");
    public static final RegistryObject<SoundEvent> FALL = registerSoundEvent("fall");

    public static final ForgeSoundType FART_SOUND_TYPE = new ForgeSoundType(1.0F, 1.0F,
            FART, STEP, PLACE, HIT, FALL);

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
