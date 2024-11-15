package com.vikkivuk.mekanismasnails.registry;

import com.vikkivuk.mekanismasnails.MekanismAsNails;
import com.vikkivuk.mekanismasnails.item.module.ModuleHydrationUnit;
import com.vikkivuk.mekanismasnails.item.module.ModuleThermoregulatorUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;

public class MANModules {
    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(MekanismAsNails.MODID);

    public static final ModuleRegistryObject<ModuleThermoregulatorUnit> THERMOREGULATOR_UNIT = MODULES.register("thermoregulator_unit", ModuleThermoregulatorUnit::new, () -> MANItems.THERMOREGULATOR_UNIT.asItem(), (builder) -> builder.maxStackSize(1).rarity(Rarity.UNCOMMON));
    public static final ModuleRegistryObject<ModuleHydrationUnit> HYDRATION_UNIT = MODULES.register("hydration_unit", ModuleHydrationUnit::new, () -> MANItems.HYDRATION_UNIT.asItem(), (builder) -> builder.maxStackSize(1).rarity(Rarity.UNCOMMON));
}