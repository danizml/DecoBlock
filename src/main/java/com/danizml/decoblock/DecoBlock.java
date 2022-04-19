package com.danizml.decoblock;

import com.danizml.decoblock.core.ModBlocks;
import com.danizml.decoblock.core.ModItems;
import com.mojang.logging.LogUtils;

import org.slf4j.Logger;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod("decoblock")
@SuppressWarnings("all")
public class DecoBlock {
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "decoblock";

    public DecoBlock() {
        IEventBus iEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ModBlocks.REGISTER.register(iEventBus);
        ModItems.REGISTER.register(iEventBus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @Mod.EventBusSubscriber(modid = DecoBlock.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class Client {
        private Client() {

        }

        private void doClientStuff(final FMLClientSetupEvent event) {
            event.enqueueWork(() -> {
            });
        }
    }
}
