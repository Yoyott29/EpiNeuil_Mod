package net.lesfessesdesgarcons.client;

import com.mojang.blaze3d.vertex.PoseStack;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.utils.ChickenUtils;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RenderLivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

// Only change the render but not the hitbox !
@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, value = Dist.CLIENT)
public class ChickenScaleHandler {
    @SubscribeEvent
    public static void onRenderLiving(RenderLivingEvent.Pre<?, ?> event) {

        if (event.getEntity() instanceof Chicken chicken) {
            PoseStack poseStack = event.getPoseStack();

           float scale = ChickenUtils.getOrCreateScale(chicken);
            poseStack.scale(scale, scale, scale);
        }
    }
}