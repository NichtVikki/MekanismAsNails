package com.vikkivuk.mekanismasnails.registry;

import com.vikkivuk.mekanismasnails.MekanismAsNails;
import mekanism.common.item.ItemModule;
import mekanism.common.registration.impl.ItemDeferredRegister;
import mekanism.common.registration.impl.ItemRegistryObject;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MANItems {
    public static final ItemDeferredRegister ITEMS = new ItemDeferredRegister(MekanismAsNails.MODID);

    public static final ItemRegistryObject<ItemModule> THERMOREGULATOR_UNIT = ITEMS.registerModule(MANModules.THERMOREGULATOR_UNIT);
    public static final ItemRegistryObject<ItemModule> HYDRATION_UNIT = ITEMS.registerModule(MANModules.HYDRATION_UNIT);

    public static final DeferredRegister<Item> BLOCK_ITEMS = DeferredRegister.create(Registries.ITEM, MekanismAsNails.MODID);
    public static final RegistryObject<BlockItem> AIR_CONDITIONER = BLOCK_ITEMS.register("air_conditioner", () -> new BlockItem(MANBlocks.AIR_CONDITIONER.get(), new Item.Properties()));
}