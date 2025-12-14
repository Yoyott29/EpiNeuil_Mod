package net.lesfessesdesgarcons.epineuil.item;

import com.google.common.collect.ImmutableMap;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.registries.ForgeRegistries;
import net.lesfessesdesgarcons.epineuil.sounds.Sounds;

import java.util.List;
import java.util.Map;

public class ModArmorItem extends ArmorItem {

    private static final ResourceLocation CUSTOM_SOUND_ID = ResourceLocation.tryParse("epineuil:phoenix_armor");
    public static final String ARMOR_SOUND_PLAYED = "armor_sound_played";

    private static final Map<Holder<ArmorMaterial>, List<MobEffectInstance>> MATERIAL_TO_EFFECT_MAP =
            (new ImmutableMap.Builder<Holder<ArmorMaterial>, List<MobEffectInstance>>())
                    .put(ArmorMaterials.CHICKEN_ARMOR,
                            List.of(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 0, true, true),
                            new MobEffectInstance(MobEffects.JUMP, 3000, 1, true, true),
                            new MobEffectInstance(MobEffects.SLOW_FALLING, 3000, 4, true, true)))
                    .put(ArmorMaterials.PHOENIX_ARMOR,
                            List.of(new MobEffectInstance(MobEffects.ABSORPTION, 3000, 1, true, true),
                            new MobEffectInstance(MobEffects.JUMP, 3000, 1, true, true),
                            new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 3000, 1, true, true),
                            new MobEffectInstance(MobEffects.NIGHT_VISION, 3000, 1, true, true),
                            new MobEffectInstance(MobEffects.SLOW_FALLING, 3000, 0, true, true)))
                    .build();

    public ModArmorItem(Holder<ArmorMaterial> material, Type type, Properties properties) {
        super(material, type, properties);
    }

    @Override
    public void onInventoryTick(ItemStack stack, Level level, Player player, int slotIndex, int selectedIndex) {
        if (level.isClientSide()) return;

    boolean hasFullSuit = hasFullSuitOfArmorOn(player);
    var data = player.getPersistentData();

    if (hasFullSuit && !data.getBoolean(ARMOR_SOUND_PLAYED)) {
        SoundEvent soundEvent = ForgeRegistries.SOUND_EVENTS.getValue(CUSTOM_SOUND_ID);

        if (soundEvent != null && player.blockPosition() != null && hasPlayerCorrectArmorOn(ArmorMaterials.PHOENIX_ARMOR, player)) {
            level.playSound(
                null,
                player.blockPosition(),
                soundEvent,
                SoundSource.PLAYERS,
                0.5F,
                1.0F
            );
        }

        data.putBoolean(ARMOR_SOUND_PLAYED, true);
        evaluateArmorEffects(player);
    }

    // Reset when armor is removed
    if (!hasFullSuit && data.getBoolean(ARMOR_SOUND_PLAYED)) {
        data.putBoolean(ARMOR_SOUND_PLAYED, false);
    }
    }

    private void evaluateArmorEffects(Player player) {
        for(Map.Entry<Holder<ArmorMaterial>, List<MobEffectInstance>> entry : MATERIAL_TO_EFFECT_MAP.entrySet()) {
            Holder<ArmorMaterial> mapArmorMaterial = entry.getKey();
            List<MobEffectInstance> mapEffect = entry.getValue();

            if(hasPlayerCorrectArmorOn(mapArmorMaterial, player)) {
                addEffectToPlayer(player, mapEffect);
            }
        }
    }

    private void addEffectToPlayer(Player player, List<MobEffectInstance> mapEffect) {
        boolean hasPlayerEffect = mapEffect.stream().allMatch(effect -> player.hasEffect(effect.getEffect()));

        if(!hasPlayerEffect) {
            for (MobEffectInstance effect : mapEffect) {
                player.addEffect(new MobEffectInstance(effect.getEffect(),
                        effect.getDuration(), effect.getAmplifier(), effect.isAmbient(), effect.isVisible()));
            }
        }
    }

    private boolean hasPlayerCorrectArmorOn(Holder<ArmorMaterial> mapArmorMaterial, Player player) {
        for(ItemStack armorStack : player.getArmorSlots()) {
            if(!(armorStack.getItem() instanceof ArmorItem)) {
                return false;
            }
        }

        ArmorItem boots = ((ArmorItem) player.getInventory().getArmor(0).getItem());
        ArmorItem leggings = ((ArmorItem) player.getInventory().getArmor(1).getItem());
        ArmorItem chestplate = ((ArmorItem) player.getInventory().getArmor(2).getItem());
        ArmorItem helmet = ((ArmorItem) player.getInventory().getArmor(3).getItem());

        return boots.getMaterial() == mapArmorMaterial && leggings.getMaterial() == mapArmorMaterial
                && chestplate.getMaterial() == mapArmorMaterial && helmet.getMaterial() == mapArmorMaterial;
    }

    private boolean hasFullSuitOfArmorOn(Player player) {
        ItemStack boots = player.getInventory().getArmor(0);
        ItemStack leggings = player.getInventory().getArmor(1);
        ItemStack chestplate = player.getInventory().getArmor(2);
        ItemStack helmet = player.getInventory().getArmor(3);

        return !boots.isEmpty() && !leggings.isEmpty() && !chestplate.isEmpty() && !helmet.isEmpty();
    }
}