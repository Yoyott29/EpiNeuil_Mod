package net.lesfessesdesgarcons.epineuil.events;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class TenderCookedSound {

    private static final ResourceLocation TENDER_ID = ResourceLocation.tryParse("epineuil:tender_piece");
    private static final ResourceLocation SOUND_ID = ResourceLocation.tryParse("epineuil:tender_cooked");

    @SubscribeEvent
    public static void onItemSmelted(PlayerEvent.ItemSmeltedEvent event) {
        Player player = event.getEntity();
        ItemStack stack = event.getSmelting();

        // Check if the smelted item is a cooked tender
        ResourceLocation itemId = ForgeRegistries.ITEMS.getKey(stack.getItem());
        
        if (TENDER_ID.equals(itemId)) {
            SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(SOUND_ID);
            
            if (soundEvent != null && !player.level().isClientSide()) {
                player.level().playSound(
                    null,
                    player.blockPosition(),
                    soundEvent,
                    SoundSource.PLAYERS,
                    0.2F,
                    1.0F
                );
            }
        }
    }
}
