package net.lesfessesdesgarcons.epineuil;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.lesfessesdesgarcons.epineuil.block.Blocks;
import net.lesfessesdesgarcons.epineuil.item.Items;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(EpiNeuil.MOD_ID)
public class EpiNeuil
{
    public static final String MOD_ID = "epineuil";

    private static final Logger LOGGER = LogUtils.getLogger();

    public EpiNeuil()
    {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);

        MinecraftForge.EVENT_BUS.register(this);

        Blocks.register(modEventBus);
        Items.register(modEventBus);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(Items.RAW_TENDER);
            event.accept(Items.TENDER_PIECE);
            event.accept(Items.TENDER_BUCKET);
            event.accept(Items.CHICKEN_BOOTS);
            event.accept(Items.CHICKEN_CHESTPLATE);
            event.accept(Items.CHICKEN_HELMET);
            event.accept(Items.CHICKEN_LEGGINGS);
            event.accept(Items.PHOENIX_BOOTS);
            event.accept(Items.PHOENIX_CHESTPLATE);
            event.accept(Items.PHOENIX_HELMET);
            event.accept(Items.PHOENIX_LEGGINGS);
        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents
    {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event)
        {

        }
    }
}
