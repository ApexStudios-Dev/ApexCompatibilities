package dev.apexstudios.apexcompatibilities.data;

import dev.apexstudios.apexcore.api.util.ApexUtil;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(value = "apexcompatibilities", dist = Dist.CLIENT)
public final class ApexCompatibilitiesDataEntryPoint {
    public ApexCompatibilitiesDataEntryPoint(IEventBus modBus) {
        modBus.addListener(GatherDataEvent.Client.class, event -> event.createProvider(output -> ApexUtil.createMetadataProvider(output, Component.literal("ApexCompatibilities resources"), PackType.SERVER_DATA)));
    }
}
