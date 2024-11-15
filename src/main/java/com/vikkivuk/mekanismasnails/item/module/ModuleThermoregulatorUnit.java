package com.vikkivuk.mekanismasnails.item.module;

import com.vikkivuk.mekanismasnails.Config;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IModule;
import mekanism.api.math.FloatingLong;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import org.jetbrains.annotations.NotNull;
import toughasnails.api.potion.TANEffects;
import toughasnails.api.temperature.ITemperature;
import toughasnails.api.temperature.TemperatureHelper;
import toughasnails.api.temperature.TemperatureLevel;
import toughasnails.temperature.TemperatureHandler;

public class ModuleThermoregulatorUnit implements ICustomModule<ModuleThermoregulatorUnit> {
    @Override
    public void tickServer(IModule<ModuleThermoregulatorUnit> module, @NotNull Player player) {
        IEnergyContainer energyContainer = module.getEnergyContainer();
        ITemperature temperatureHandler = TemperatureHelper.getTemperatureData(player);
        TemperatureLevel temperatureLevel = TemperatureHelper.getTemperatureAtPos(player.level(), player.blockPosition());
        double energyUsage = getEnergyUsage(temperatureLevel);

        if (energyContainer != null && energyContainer.getEnergy().getValue() > energyUsage) {
            temperatureHandler.setLevel(TemperatureLevel.NEUTRAL);
            module.useEnergy(player, FloatingLong.create(energyUsage));
        }
    }

    private static double getEnergyUsage(TemperatureLevel temperatureLevel) {
        double energyUsage = Config.moduleThermoregulatorUnitUsage;
        switch (temperatureLevel) {
            case COLD, WARM:
                energyUsage *= 1.5;
                break;
            case ICY, HOT:
                energyUsage *= 3;
                break;
            case NEUTRAL:
                energyUsage *= 0;
                break;
        }

        return energyUsage;
    }
}
