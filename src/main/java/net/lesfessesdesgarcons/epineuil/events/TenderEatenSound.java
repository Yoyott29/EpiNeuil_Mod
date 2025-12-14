package net.lesfessesdesgarcons.epineuil.events;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TenderEatenSound {

    private static final ResourceLocation TENDER_PIECE_ID = ResourceLocation.tryParse("epineuil:tender_piece");
    private static final ResourceLocation TENDER_BUCKET_ID = ResourceLocation.tryParse("epineuil:tender_bucket");
    private static final ResourceLocation SOUND_ID = ResourceLocation.tryParse("epineuil:ho_le_poulet");

    @SubscribeEvent
    public static void onItemFinishUse(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }

        ItemStack stack = event.getItem();
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());

        // Check if the eaten item is tender_piece or tender_bucket
        if (TENDER_PIECE_ID.equals(itemId) || TENDER_BUCKET_ID.equals(itemId)) {
            SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(SOUND_ID);

            if (soundEvent != null && !player.level().isClientSide()) {
                player.level().playSound(
                    null,
                    player.blockPosition(),
                    soundEvent,
                    SoundSource.PLAYERS,
                    0.5F,
                    1.0F
                );
            }
        }
    }
}
