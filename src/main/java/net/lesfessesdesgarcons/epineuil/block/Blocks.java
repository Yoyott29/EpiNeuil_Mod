package net.lesfessesdesgarcons.epineuil.block;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Blocks {

    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, EpiNeuil.MOD_ID);

    public static final RegistryObject<Block> POULYTE_BLOCK = BLOCKS.register("poulyte_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(2.0f)
                    .sound(SoundType.STONE)
            ));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
