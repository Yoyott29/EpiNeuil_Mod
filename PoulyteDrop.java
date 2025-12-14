package net.lesfessesdesgarcons.epineuil.event;

import net.lesfessesdesgarcons.epineuil.EpiNeuil;
import net.lesfessesdesgarcons.epineuil.block.Blocks;
import net.lesfessesdesgarcons.epineuil.item.Items;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = EpiNeuil.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PoulyteDrop {

    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event) {


        if (!(event.getLevel() instanceof ServerLevel level)) return;

        Player player = event.getPlayer();
        if (player == null) return;

        if (player.isCreative()) return;


        if (!event.getState().is(Blocks.POULYTE_BLOCK.get())) return;

        BlockPos pos = event.getPos();


        event.setCanceled(true);
        level.removeBlock(pos, false);
        ItemStack drop = new ItemStack(Items.POULYTE.get(), 1);
        ItemEntity itemEntity = new ItemEntity(level,
                pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5,
                drop);

        level.addFreshEntity(itemEntity);
    }
}
