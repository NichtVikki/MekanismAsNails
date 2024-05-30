package dev.dercoderjo.toughasmekanism.registry;

import dev.dercoderjo.toughasmekanism.ToughAsMekanism;
import dev.dercoderjo.toughasmekanism.item.module.ModuleHydrationUnit;
import dev.dercoderjo.toughasmekanism.item.module.ModuleThermoregulatorUnit;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;

public class TAMModules {
    private TAMModules() {
    }


    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(ToughAsMekanism.MODID);

    public static final ModuleRegistryObject<ModuleThermoregulatorUnit> THERMOREGULATOR_UNIT = MODULES.register("thermoregulator_unit", ModuleThermoregulatorUnit::new, () -> TAMItems.THERMOREGULATOR_UNIT.asItem(), (builder) -> builder.maxStackSize(1).rarity(Rarity.UNCOMMON));
    public static final ModuleRegistryObject<ModuleHydrationUnit> HYDRATION_UNIT = MODULES.register("hydration_unit", ModuleHydrationUnit::new, () -> TAMItems.HYDRATION_UNIT.asItem(), (builder) -> builder.maxStackSize(1).rarity(Rarity.UNCOMMON));
}
