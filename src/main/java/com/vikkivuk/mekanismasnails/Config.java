package com.vikkivuk.mekanismasnails;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.config.ModConfigEvent;

@Mod.EventBusSubscriber(modid = MekanismAsNails.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    private static final ForgeConfigSpec.LongValue MODULE_THERMOREGULATOR_UNIT_USAGE = BUILDER
            .comment("How much energy the Thermoregulator unit uses per tick")
            .defineInRange("moduleThermoregulatorUnitUsage", 400L, 0L, 5000L);

    private static final ForgeConfigSpec.LongValue MODULE_HYDRATION_UNIT_USAGE = BUILDER
            .comment("How much energy the Hydration unit uses per tick")
            .defineInRange("moduleHydrationUnitUsage", 300L, 0L, 5000L);

    private static final ForgeConfigSpec.IntValue MODULE_HYDRATION_UNIT_GIVES_THIRST = BUILDER
            .comment("How much thirst the Hydration unit gives per tick")
            .defineInRange("moduleHydrationUnitGivesThirst", 1, 0, 20);

    static final ForgeConfigSpec SPEC = BUILDER.build();

    public static Long moduleThermoregulatorUnitUsage;
    public static Long moduleHydrationUnitUsage;
    public static Integer moduleHydrationUnitGivesThirst;

    private static boolean validateItemName(final Object obj) {
        return obj instanceof String itemName && BuiltInRegistries.ITEM.containsKey(new ResourceLocation(itemName));
    }

    @SubscribeEvent
    static void onLoad(final ModConfigEvent event) {
        moduleThermoregulatorUnitUsage = MODULE_THERMOREGULATOR_UNIT_USAGE.get();
        moduleHydrationUnitUsage = MODULE_HYDRATION_UNIT_USAGE.get();
        moduleHydrationUnitGivesThirst = MODULE_HYDRATION_UNIT_GIVES_THIRST.get();
    }
}
