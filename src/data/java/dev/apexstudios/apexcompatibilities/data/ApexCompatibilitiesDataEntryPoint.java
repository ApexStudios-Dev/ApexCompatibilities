package dev.apexstudios.apexcompatibilities.data;

import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.data.event.GatherDataEvent;

@Mod(value = "apexcompatibilities", dist = Dist.CLIENT)
public final class ApexCompatibilitiesDataEntryPoint {
    public ApexCompatibilitiesDataEntryPoint(IEventBus modBus) {
        modBus.addListener(GatherDataEvent.Client.class, event -> event.createProvider(output -> PackMetadataGenerator.forFeaturePack(output, Component.literal("ApexCompatibilities resources"))));
    }
}
