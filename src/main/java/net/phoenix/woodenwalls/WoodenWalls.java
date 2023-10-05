package net.phoenix.woodenwalls;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.*;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WoodenWalls implements ModInitializer {
    public static final String MOD_ID = "wooden_walls";
    public static final Logger LOGGER = LogManager.getLogger(MOD_ID);
    public static Block OAK_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.OAK_WOOD));
    public static Block BIRCH_WALL = new WallBlock(FabricBlockSettings.copyOf(Blocks.BIRCH_WOOD));


    @Override
    public void onInitialize() {


        //Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "oak_wall"), OAK_WALL);
        //Registry.register(Registries.ITEM, new Identifier(MOD_ID, "oak_wall"), new BlockItem(OAK_WALL, new FabricItemSettings()));

        //Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "birch_wall"), BIRCH_WALL);
        //Registry.register(Registries.ITEM, new Identifier(MOD_ID, "birch_wall"), new BlockItem(BIRCH_WALL, new FabricItemSettings()));
    }

}