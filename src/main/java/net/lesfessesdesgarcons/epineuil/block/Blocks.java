package net.lesfessesdesgarcons.epineuil.block;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {

        public static final DeferredRegister<Block> BLOCKS =
                DeferredRegister.create(ForgeRegistries.BLOCKS, EpiNeuil.MOD_ID);

        public static final RegistryObject<Block> CHICKEN_BLOCK =
                BLOCKS.register("chicken_block", CustomChickenBlock::new);

        public static void register(IEventBus eventBus) {
                BLOCKS.register(eventBus);
        }
}
