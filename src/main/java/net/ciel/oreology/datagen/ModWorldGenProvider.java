package net.ciel.oreology.datagen;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

import net.ciel.oreology.Oreology;
import net.ciel.oreology.worldgen.ModBiomeModifiers;
import net.ciel.oreology.worldgen.ModConfiguredFeatures;
import net.ciel.oreology.worldgen.ModPlacedFeatures;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.registries.ForgeRegistries;

public class ModWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public static final RegistrySetBuilder BUILDER = new RegistrySetBuilder()
        /**
         * * There's a type error here when using VSCode, it can be safely ignored.
         * ! Java(603979903)
         */
        .add(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
        .add(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
        .add(ForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomeModifiers::bootstrap);

    public ModWorldGenProvider(PackOutput output, CompletableFuture<Provider> registries) {
        super(output, registries, BUILDER, Set.of(Oreology.MOD_ID));
    } 
}
