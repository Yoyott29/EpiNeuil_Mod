package net.lesfessesdesgarcons.epineuil.events;

import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistries;

@OnlyIn(Dist.CLIENT)
public class PlayMusicContinuous {

    private static final ResourceLocation CUSTOM_SOUND_ID = ResourceLocation.tryParse("epineuil:music");
    private boolean isPlaying = false;

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        LocalPlayer player = Minecraft.getInstance().player;
        if (player == null) return;

        if (!isPlaying) {
            // Start playing sound
            SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(CUSTOM_SOUND_ID);
            if (soundEvent != null) {
                player.playNotifySound(soundEvent, SoundSource.PLAYERS, 1.0F, 1.0F);
                isPlaying = true;
            }
        }
    }
}
