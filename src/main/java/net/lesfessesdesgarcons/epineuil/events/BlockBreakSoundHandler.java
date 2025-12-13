package net.lesfessesdesgarcons.epineuil.events;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.sounds.Sounds;
import net.minecraft.sounds.SoundSource;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID)
public class BlockBreakSoundHandler {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getLevel() == null || event.getPlayer() == null) return;

        var level = event.getLevel();
        var pos = event.getPos();

        // Play the fart sound at the block position for all nearby players
        level.playSound(
                null, // null means broadcast to all nearby players
                pos,
                Sounds.FART.get(),
                SoundSource.BLOCKS,
                1.0f,
                1.0f
        );
    }
}
