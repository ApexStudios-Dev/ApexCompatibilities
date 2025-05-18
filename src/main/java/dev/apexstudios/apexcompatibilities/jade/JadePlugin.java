package dev.apexstudios.apexcompatibilities.jade;

import dev.apexstudios.apexcore.lib.component.block.BlockComponentHelper;
import dev.apexstudios.apexcore.lib.component.block.BlockComponentTypes;
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
            var multiBlock = BlockComponentHelper.getComponent(blockState, BlockComponentTypes.MULTI_BLOCK);

            if(multiBlock == null)
                return accessor;

            var origin = multiBlock.getOrigin(blockAccessor.getPosition(), blockState);

            // redirect multi blocks to origin point for block entity data
            return registration.blockAccessor().from(blockAccessor)
                    .hit(blockAccessor.getHitResult().withPosition(origin))
                    .blockEntity(() -> blockAccessor.getLevel().getBlockEntity(origin))
            .build();
        });
    }
}
