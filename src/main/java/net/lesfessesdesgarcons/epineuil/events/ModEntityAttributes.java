package net.lesfessesdesgarcons.epineuil.events;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.event.entity.EntityAttributeModificationEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntityAttributes {

    @SubscribeEvent
    public static void onModifyAttributes(EntityAttributeModificationEvent event) {
        event.add(EntityType.CHICKEN, Attributes.ATTACK_DAMAGE);
    }
}
