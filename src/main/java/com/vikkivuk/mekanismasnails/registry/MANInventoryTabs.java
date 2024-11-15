package com.vikkivuk.mekanismasnails.registry;

import com.vikkivuk.mekanismasnails.MekanismAsNails;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MANInventoryTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MekanismAsNails.MODID);

    public static final RegistryObject<CreativeModeTab> MOD_TAB = CREATIVE_MODE_TABS.register("mekanismasnails", () -> CreativeModeTab.builder()
            .icon(() -> MANItems.THERMOREGULATOR_UNIT.get().getDefaultInstance())
            .title(Component.literal("Mekanism As Nails"))
            .displayItems((parameters, output) -> {
                output.accept(MANItems.THERMOREGULATOR_UNIT.get().getDefaultInstance());
                output.accept(MANItems.HYDRATION_UNIT.get().getDefaultInstance());
                output.accept(MANItems.AIR_CONDITIONER.get().getDefaultInstance());
            }).build());
}
