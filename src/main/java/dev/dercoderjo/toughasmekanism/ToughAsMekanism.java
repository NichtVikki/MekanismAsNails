package dev.dercoderjo.toughasmekanism;

import com.mojang.logging.LogUtils;
import dev.dercoderjo.toughasmekanism.registry.TAMInventoryTabs;
import dev.dercoderjo.toughasmekanism.registry.TAMItems;
import dev.dercoderjo.toughasmekanism.registry.TAMModules;
import mekanism.api.MekanismIMC;
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
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(ToughAsMekanism.MODID)
public class ToughAsMekanism {
    public static final String MODID = "toughasmekanism";
    private static final Logger LOGGER = LogUtils.getLogger();

    public ToughAsMekanism() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::imcQueue);

        MinecraftForge.EVENT_BUS.register(this);

        modEventBus.addListener(this::addCreative);

        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.SPEC);

        TAMModules.MODULES.register(modEventBus);
        TAMItems.ITEMS.register(modEventBus);
        TAMInventoryTabs.TABS.register(modEventBus);
    }

    private void imcQueue(InterModEnqueueEvent event) {
        MekanismIMC.addMekaSuitHelmetModules(TAMModules.HYDRATION_UNIT);

        MekanismIMC.addMekaSuitBodyarmorModules(TAMModules.THERMOREGULATOR_UNIT);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
    }

    @Mod.EventBusSubscriber(modid = MODID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void onClientSetup(FMLClientSetupEvent event) {
        }
    }
}
