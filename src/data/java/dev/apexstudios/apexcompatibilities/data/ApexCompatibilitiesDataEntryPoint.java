package dev.apexstudios.apexcompatibilities.data;

import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
import dev.apexstudios.apexcore.lib.data.ProviderTypes;
import dev.apexstudios.apexcore.lib.data.ResourceGenerator;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(value = ApexCompatibilities.ID, dist = Dist.CLIENT)
public final class ApexCompatibilitiesDataEntryPoint {
    public ApexCompatibilitiesDataEntryPoint(IEventBus modBus) {
        ResourceGenerator.of(modBus, generator -> {
            generator.pack()
                    .providing(ProviderTypes.LANGUAGE, (context, provider) -> {

                    });
        });
    }
}
