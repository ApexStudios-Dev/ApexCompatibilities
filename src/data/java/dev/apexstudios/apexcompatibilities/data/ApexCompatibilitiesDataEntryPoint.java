package dev.apexstudios.apexcompatibilities.data;

import dev.apexstudios.apexcore.lib.data.ResourceGenerator;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = "apexcompatibilities", dist = Dist.CLIENT)
public final class ApexCompatibilitiesDataEntryPoint {
    public ApexCompatibilitiesDataEntryPoint(IEventBus modBus) {
        ResourceGenerator.of(modBus, ResourceGenerator::pack);
    }
}
