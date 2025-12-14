package net.lesfessesdesgarcons.event;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.item.Items;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(
        modid = EpiNeuil.MOD_ID,
        bus = Mod.EventBusSubscriber.Bus.FORGE
)
public class ChickenDrop {

    @SubscribeEvent
    public static void onChickenDrops(LivingDropsEvent event) {

        LivingEntity entity = event.getEntity();
        if (!(entity instanceof Chicken)) return;

        // Côté serveur uniquement
        if (entity.level().isClientSide()) return;

        event.getDrops().clear();
        ItemStack tender = new ItemStack(Items.TENDER.get(), 1);

        ItemEntity drop = new ItemEntity(
                entity.level(),
                entity.getX(),
                entity.getY(),
                entity.getZ(),
                tender
        );

        event.getDrops().add(drop);
    }
}

