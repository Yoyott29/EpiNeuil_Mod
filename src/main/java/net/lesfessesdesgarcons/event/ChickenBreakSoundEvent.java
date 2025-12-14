package net.lesfessesdesgarcons.event;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.block.Blocks;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ChickenBreakSoundEvent {

    @SubscribeEvent
    public static void onBreak(BlockEvent.BreakEvent event) {
        Level level = (Level) event.getLevel();
        if (level.isClientSide()) return;

        if (event.getState().is(Blocks.POULYTE_BLOCK.get())) {
            level.playSound(
                    null,
                    event.getPos(),
                    SoundEvents.CHICKEN_HURT,   // tu peux mettre CHICKEN_AMBIENT ou CHICKEN_DEATH
                    SoundSource.BLOCKS,
                    1.0f,
                    1.0f
            );
        }
    }
}
