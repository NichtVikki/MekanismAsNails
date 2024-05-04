package dev.dercoderjo.toughasmekanism.registry;

import dev.dercoderjo.toughasmekanism.ToughAsMekanism;
import dev.dercoderjo.toughasmekanism.item.module.ModuleThermoregulatorUnit;
import mekanism.api.MekanismAPI;
import mekanism.api.gear.ModuleData;
import mekanism.common.registration.impl.ModuleDeferredRegister;
import mekanism.common.registration.impl.ModuleRegistryObject;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class Modules {
    private Modules() {
    }


    public static final ModuleDeferredRegister MODULES = new ModuleDeferredRegister(ToughAsMekanism.MODID);

    public static final ModuleRegistryObject<ModuleThermoregulatorUnit> THERMOREGULATOR_UNIT = MODULES.register("thermoregulator_unit", ModuleThermoregulatorUnit::new, () -> Items.THERMOREGULATOR_UNIT.asItem(), (builder) -> builder.maxStackSize(1).rarity(Rarity.UNCOMMON));
}
