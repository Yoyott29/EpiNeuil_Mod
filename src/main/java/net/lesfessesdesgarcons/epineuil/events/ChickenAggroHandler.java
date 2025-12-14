package net.lesfessesdesgarcons.epineuil.events;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.utils.ChickenUtils;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID)
public class ChickenAggroHandler {

    @SubscribeEvent
    public static void onEntityJoin(EntityJoinLevelEvent event) {
        if (event.getLevel().isClientSide()) return;

        if (event.getEntity() instanceof Chicken chicken) {

            PathfinderMob mob = (PathfinderMob) chicken;

            float scaleFactor = ChickenUtils.getOrCreateScale(chicken);

            AttributeInstance health = chicken.getAttribute(Attributes.MAX_HEALTH);
            if (health != null) {
                double baseHealth = 4.0;
                double healthMultiplier = 1.0 + (scaleFactor - 1.0) * 0.5;
                health.setBaseValue(baseHealth * healthMultiplier);
                chicken.setHealth((float) health.getBaseValue());
            }

            // scale damage
            AttributeInstance dmg = chicken.getAttribute(Attributes.ATTACK_DAMAGE);
            if (dmg != null) {
                double baseDamage = 2.0;
                double damageMultiplier = 1.0 + (scaleFactor - 1.0) * 0.5;
                dmg.setBaseValue(baseDamage * damageMultiplier);
            }

            // Make aggressive
            mob.goalSelector.addGoal(2, new MeleeAttackGoal(mob, 1.2D, true));
            mob.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(mob, Player.class, true));
            mob.setAggressive(true);
        }
    }
}
