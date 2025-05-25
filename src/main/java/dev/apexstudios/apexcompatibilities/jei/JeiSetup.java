package dev.apexstudios.apexcompatibilities.jei;

import dev.apexstudios.apexcompatibilities.ApexCompatibilities;
import dev.apexstudios.apexcompatibilities.CompatManager;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.helpers.IPlatformFluidHelper;
import mezz.jei.api.registration.IAdvancedRegistration;
import mezz.jei.api.registration.IExtraIngredientRegistration;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IIngredientAliasRegistration;
import mezz.jei.api.registration.IModInfoRegistration;
import mezz.jei.api.registration.IModIngredientRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import mezz.jei.api.registration.IRuntimeRegistration;
import mezz.jei.api.registration.ISubtypeRegistration;
import mezz.jei.api.registration.IVanillaCategoryExtensionRegistration;
import mezz.jei.api.runtime.IJeiRuntime;
import mezz.jei.api.runtime.config.IJeiConfigManager;
import net.minecraft.resources.ResourceLocation;

@JeiPlugin
public final class JeiSetup implements IModPlugin {
    private final CompatManager<JeiSetup, IModPlugin> manager = CompatManager.create(this, builder -> {});

    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(ApexCompatibilities.ID, "jei_plugin");
    }

    @Override
    public void registerItemSubtypes(ISubtypeRegistration registration) {
        manager.forEach(compat -> compat.registerItemSubtypes(registration));
    }

    @Override
    public <T> void registerFluidSubtypes(ISubtypeRegistration registration, IPlatformFluidHelper<T> platformFluidHelper) {
        manager.forEach(compat -> compat.registerFluidSubtypes(registration, platformFluidHelper));
    }

    @Override
    public void registerIngredients(IModIngredientRegistration registration) {
        manager.forEach(compat -> compat.registerIngredients(registration));
    }

    @Override
    public void registerExtraIngredients(IExtraIngredientRegistration registration) {
        manager.forEach(compat -> compat.registerExtraIngredients(registration));
    }

    @Override
    public void registerIngredientAliases(IIngredientAliasRegistration registration) {
        manager.forEach(compat -> compat.registerIngredientAliases(registration));
    }

    @Override
    public void registerModInfo(IModInfoRegistration modAliasRegistration) {
        manager.forEach(compat -> compat.registerModInfo(modAliasRegistration));
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        manager.forEach(compat -> compat.registerCategories(registration));
    }

    @Override
    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
        manager.forEach(compat -> compat.registerVanillaCategoryExtensions(registration));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        manager.forEach(compat -> compat.registerRecipes(registration));
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        manager.forEach(compat -> compat.registerRecipeTransferHandlers(registration));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        manager.forEach(compat -> compat.registerRecipeCatalysts(registration));
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        manager.forEach(compat -> compat.registerGuiHandlers(registration));
    }

    @Override
    public void registerAdvanced(IAdvancedRegistration registration) {
        manager.forEach(compat -> compat.registerAdvanced(registration));
    }

    @Override
    public void registerRuntime(IRuntimeRegistration registration) {
        manager.forEach(compat -> compat.registerRuntime(registration));
    }

    @Override
    public void onRuntimeAvailable(IJeiRuntime jeiRuntime) {
        manager.forEach(compat -> compat.onRuntimeAvailable(jeiRuntime));
    }

    @Override
    public void onRuntimeUnavailable() {
        manager.forEach(IModPlugin::onRuntimeUnavailable);
    }

    @Override
    public void onConfigManagerAvailable(IJeiConfigManager configManager) {
        manager.forEach(compat -> compat.onConfigManagerAvailable(configManager));
    }
}
