package com.vikkivuk.mekanismasnails.registry;

import com.vikkivuk.mekanismasnails.MekanismAsNails;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class MANBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(Registries.BLOCK, MekanismAsNails.MODID);

    public static final RegistryObject<Block> AIR_CONDITIONER = BLOCKS.register("air_conditioner", () -> new Block(Block.Properties.of().lightLevel((state) -> 13).noOcclusion().strength(0.3F).noCollission()));
}
