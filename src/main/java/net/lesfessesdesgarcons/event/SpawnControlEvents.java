package net.lesfessesdesgarcons.event;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class SpawnControlEvents {

    @SubscribeEvent
    public static void onEntityJoinLevel(EntityJoinLevelEvent event) {
    
        if (event.getLevel().isClientSide()) return;

        Entity entity = event.getEntity();

        if (entity instanceof Animal && !(entity instanceof Chicken)) {
            event.setCanceled(true);
        }
    }
}
