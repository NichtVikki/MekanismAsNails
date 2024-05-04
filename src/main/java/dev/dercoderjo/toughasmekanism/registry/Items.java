package dev.dercoderjo.toughasmekanism.registry;

import dev.dercoderjo.toughasmekanism.ToughAsMekanism;
import mekanism.api.MekanismAPI;
import mekanism.api.providers.IModuleDataProvider;
import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class Items {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(ToughAsMekanism.MODID);

    public static final ItemRegistryObject<ItemModule> THERMOREGULATOR_UNIT = ITEMS.registerModule(Modules.THERMOREGULATOR_UNIT);
}
