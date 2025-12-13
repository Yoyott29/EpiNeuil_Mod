package net.lesfessesdesgarcons.epineuil.events;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

public class BreakBlockSound {

    private static final ResourceLocation CUSTOM_SOUND_ID = ResourceLocation.tryParse("epineuil:fart");

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {

        if (!(event.getLevel() instanceof ServerLevel level)) {
            return;
        }

        // Get the sound event from the registry
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(CUSTOM_SOUND_ID);

        if (soundEvent == null) {
            // fallback if the sound is not registered
            soundEvent = net.minecraft.sounds.SoundEvents.PLAYER_HURT;
        }

        level.playSound(
                null, // null = everyone nearby hears it
                event.getPos(),
                soundEvent,
                SoundSource.PLAYERS,
                1.0F,
                1.0F
        );
    }
}
