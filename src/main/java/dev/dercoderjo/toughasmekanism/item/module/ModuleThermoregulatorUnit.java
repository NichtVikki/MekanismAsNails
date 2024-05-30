package dev.dercoderjo.toughasmekanism.item.module;

import dev.dercoderjo.toughasmekanism.Config;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import mekanism.api.math.FloatingLong;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import toughasnails.api.potion.TANEffects;

public class ModuleThermoregulatorUnit implements ICustomModule<ModuleThermoregulatorUnit> {
    @Override
    public void tickServer(IModule<ModuleThermoregulatorUnit> module, Player player) {
        IEnergyContainer energyContainer = module.getEnergyContainer();
        if (energyContainer != null && energyContainer.getEnergy().getValue() > 0) {
            player.addEffect(new MobEffectInstance(TANEffects.CLIMATE_CLEMENCY.get(), 1, 0, false, false, false));
            module.useEnergy(player, FloatingLong.create(Config.moduleThermoregulatorUnitUsage));
        }
    }
}
