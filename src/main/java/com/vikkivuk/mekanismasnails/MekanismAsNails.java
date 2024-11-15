package com.vikkivuk.mekanismasnails;

import com.mojang.logging.LogUtils;
import com.vikkivuk.mekanismasnails.registry.MANBlocks;
import com.vikkivuk.mekanismasnails.registry.MANInventoryTabs;
import com.vikkivuk.mekanismasnails.registry.MANItems;
import com.vikkivuk.mekanismasnails.registry.MANModules;
import mekanism.api.MekanismIMC;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(MekanismAsNails.MODID)
public class MekanismAsNails {
    public static final String MODID = "mekanismasnails";
    public static final Logger LOGGER = LogUtils.getLogger();

    public MekanismAsNails() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::imcQueue);

        MinecraftForge.EVENT_BUS.register(this);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        MANModules.MODULES.register(modEventBus);
        MANBlocks.BLOCKS.register(modEventBus);
        MANItems.ITEMS.register(modEventBus);
        MANItems.BLOCK_ITEMS.register(modEventBus);
        MANInventoryTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(MANModules.HYDRATION_UNIT);
        MekanismIMC.addMekaSuitBodyarmorModules(MANModules.THERMOREGULATOR_UNIT);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }
}
