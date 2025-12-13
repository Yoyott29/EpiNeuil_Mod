package net.lesfessesdesgarcons.epineuil.mixin;

import net.lesfessesdesgarcons.epineuil.sounds.Sounds;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.resources.ResourceLocation;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(SoundEngine.class)
public class SoundEngineMixin {

    @ModifyVariable(
        method = "play(Lnet/minecraft/client/resources/sounds/SoundInstance;)V",
        at = @At("HEAD"),
        argsOnly = true
    )
    private SoundInstance replaceBlockBreakSound(SoundInstance instance) {
        if (instance == null) return instance;

        ResourceLocation loc = instance.getLocation();
        if (loc != null) {
            String namespace = loc.getNamespace();
            String path = loc.getPath();
            
            // Check for block break sounds - try multiple patterns
            if (path.contains("break") || path.contains("dig")) {
                // Replace with fart sound
                return SimpleSoundInstance.forUI(
                        Sounds.FART.get(),
                        instance.getVolume(),
                        instance.getPitch()
                );
            }
        }
        return instance;
    }
}