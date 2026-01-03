package dev.apexstudios.apexcompatibilities.jade;

import dev.apexstudios.apexcore.api.multiblock.MultiBlock;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public final class JadePlugin implements IWailaPlugin {
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.addRayTraceCallback((hitResult, accessor, original) -> {
            if(!(accessor instanceof BlockAccessor blockAccessor))
                return accessor;

            var blockState = blockAccessor.getBlockState();

            if(!MultiBlock.isMultiBlock(blockState))
                return accessor;

            var origin = MultiBlock.getOrigin(blockAccessor.getPosition(), blockState);

            // redirect multi blocks to origin point for block entity data
            return registration.blockAccessor().from(blockAccessor)
                    .hit(blockAccessor.getHitResult().withPosition(origin))
                    .blockEntity(() -> blockAccessor.getLevel().getBlockEntity(origin))
            .build();
        });
    }
}
