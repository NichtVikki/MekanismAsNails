package dev.dercoderjo.toughasmekanism.item.module;

import mekanism.api.energy.IEnergyContainer;
import mekanism.api.gear.ICustomModule;
import mekanism.api.gear.IHUDElement;
import mekanism.api.gear.IModule;
import mekanism.api.gear.IModuleHelper;
import mekanism.api.math.FloatingLong;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.fluids.capability.IFluidHandlerItem;
import toughasnails.api.thirst.IThirst;
import toughasnails.api.thirst.ThirstHelper;
import toughasnails.core.ToughAsNails;

import java.util.function.Consumer;

public class ModuleHydrationUnit implements ICustomModule<ModuleHydrationUnit> {
    @Override
    public void tickServer(IModule<ModuleHydrationUnit> module, Player player) {
        IEnergyContainer energyContainer = module.getEnergyContainer();
        if (energyContainer != null && energyContainer.getEnergy().getValue() > 0 && ThirstHelper.getThirst(player).getThirst() < 20) {
            IThirst thirst = ThirstHelper.getThirst(player);
            thirst.setThirst(thirst.getThirst() + 1);
            module.useEnergy(player, FloatingLong.create(100));
        }
    }

    @Override
    public void addHUDElements(IModule<ModuleHydrationUnit> module, Player player, Consumer<IHUDElement> hudElementAdder) {
        if (module.isEnabled()) {
            hudElementAdder.accept(IModuleHelper.INSTANCE.hudElementPercent(new ResourceLocation("toughasmekanism:textures/gui/hud/hydration_unit"), 1));
        }
    }
}
