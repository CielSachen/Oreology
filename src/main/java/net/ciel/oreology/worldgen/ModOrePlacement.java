package net.ciel.oreology.worldgen;

import java.util.List;

import net.minecraft.world.level.levelgen.placement.BiomeFilter;
import net.minecraft.world.level.levelgen.placement.CountPlacement;
import net.minecraft.world.level.levelgen.placement.InSquarePlacement;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;
import net.minecraft.world.level.levelgen.placement.RarityFilter;

public class ModOrePlacement {
    public static List<PlacementModifier> orePlacement(PlacementModifier veinsPerChunk, PlacementModifier heightRange) {
        return List.of(veinsPerChunk, InSquarePlacement.spread(), heightRange, BiomeFilter.biome());
    }

    public static List<PlacementModifier> commonOrePlacement(int veinsPerChunk, PlacementModifier heightRange) {
        return orePlacement(CountPlacement.of(veinsPerChunk), heightRange);
    }

    public static List<PlacementModifier> rareOrePlacement(int veinsPerChunk, PlacementModifier heightRange) {
        return orePlacement(RarityFilter.onAverageOnceEvery(veinsPerChunk), heightRange);
    }
}
