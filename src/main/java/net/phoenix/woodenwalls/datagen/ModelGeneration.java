package net.phoenix.woodenwalls.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.WallBlock;
import net.minecraft.data.client.*;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.phoenix.woodenwalls.WoodenWalls;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import static net.phoenix.woodenwalls.WoodenWalls.MOD_ID;

public class ModelGeneration extends FabricModelProvider {

    public static HashMap<WallBlock, Block> blocks = new HashMap<>();


    public ModelGeneration(FabricDataOutput output) {
        super(output);
    }

    public void generateWall(BlockStateModelGenerator blockStateModelGenerator, WallBlock block, Block inherit){
        TextureMap textureMap = TextureMap.all(inherit);

        Identifier post = Models.TEMPLATE_WALL_POST.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier low = Models.TEMPLATE_WALL_SIDE.upload(block, textureMap, blockStateModelGenerator.modelCollector);
        Identifier tall = Models.TEMPLATE_WALL_SIDE_TALL.upload(block, textureMap, blockStateModelGenerator.modelCollector);

        blockStateModelGenerator.blockStateCollector.accept(BlockStateModelGenerator.createWallBlockState(block, post, low, tall));
        blockStateModelGenerator.registerParentedItemModel(block.asItem(), Models.WALL_INVENTORY.upload(block, textureMap, blockStateModelGenerator.modelCollector ));
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        Registries.BLOCK.forEach(block -> {
            if(block.getName().contains(Text.literal("wood")) || block.getName().contains(Text.literal("Wood"))) {
                String block_name = block.getName().toString().split(" ")[1] + "Wall";
                WallBlock wallBlock = new WallBlock(FabricBlockSettings.copyOf(block));
                blocks.put(Registry.register(Registries.BLOCK, new Identifier(MOD_ID, block_name), wallBlock), block);
            }
        });

        for(Map.Entry<WallBlock, Block> entry : blocks.entrySet()) {
            generateWall(blockStateModelGenerator, entry.getKey(), entry.getValue());
        }
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
