package com.vikkivuk.mekanismasnails.item.module;

import com.vikkivuk.mekanismasnails.Config;
import com.vikkivuk.mekanismasnails.MekanismAsNails;
import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.*;
import mekanism.api.math.FloatingLong;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;
import toughasnails.api.potion.TANEffects;
import toughasnails.api.temperature.TemperatureHelper;
import toughasnails.api.temperature.TemperatureLevel;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;

import java.util.function.Consumer;

public class ModuleHydrationUnit implements ICustomModule<ModuleHydrationUnit> {
    private static final ResourceLocation icon = new ResourceLocation(MekanismAsNails.MODID, "textures/gui/hud/hydration_unit");

    @Override
    public void tickServer(IModule<ModuleHydrationUnit> module, @NotNull Player player) {
        IThirst thirst = ThirstHelper.getThirst(player);
        IEnergyContainer energyContainer = module.getEnergyContainer();
        TemperatureLevel temperatureLevel = TemperatureHelper.getTemperatureAtPos(player.level(), player.blockPosition());
        double energyUsage = Config.moduleHydrationUnitUsage * (temperatureLevel == TemperatureLevel.HOT || temperatureLevel == TemperatureLevel.ICY ? 2 : 1);

        if (energyContainer != null && energyContainer.getEnergy().getValue() > energyUsage) {
            thirst.setThirst(thirst.getThirst() + Config.moduleHydrationUnitGivesThirst);
            module.useEnergy(player, FloatingLong.create(energyUsage));
        }
    }

    @Override
    public void addHUDElements(IModule<ModuleHydrationUnit> module, @NotNull Player player, @NotNull Consumer<IHUDElement> hudElementAdder) {
        if (module.isEnabled()) {
            hudElementAdder.accept(IModuleHelper.INSTANCE.hudElementPercent(icon, 1));
        }
    }
}
