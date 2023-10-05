package net.phoenix.woodenwalls.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.registry.*;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import net.phoenix.woodenwalls.WoodenWalls;

import java.util.Map;
import java.util.concurrent.CompletableFuture;

public class TagGenerator extends FabricTagProvider<Block> {
    public TagGenerator(FabricDataOutput dataGenerator, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(dataGenerator, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup arg) {
        TagKey<Block> walls = TagKey.of(Registries.BLOCK.getKey(), new Identifier("minecraft", "walls"));

        for(Map.Entry<WallBlock, Block> entry : ModelGeneration.blocks.entrySet()) {
            getOrCreateTagBuilder(walls).add(entry.getKey());
        }
    }
}
