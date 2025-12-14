package net.lesfessesdesgarcons.epineuil.utils;

import net.minecraft.world.entity.animal.Chicken;

public class ChickenUtils {
    private static final String SCALE_TAG = "EpiNeuilChickenScale";

    public static float getOrCreateScale(Chicken chicken) {
        if (!chicken.getPersistentData().contains(SCALE_TAG)) {
            float scale = 1F + (chicken.getId() % 20) * 0.5F;
            chicken.getPersistentData().putFloat(SCALE_TAG, scale);
        }
        return chicken.getPersistentData().getFloat(SCALE_TAG);
    }
}
