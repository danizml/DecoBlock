package com.danizml.decoblock.core;

import java.util.function.Function;
import java.util.function.Supplier;

import javax.annotation.Nullable;

import com.danizml.decoblock.DecoBlock;
import com.danizml.decoblock.block.*;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("all")
public class ModBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, DecoBlock.MOD_ID);

    public static final RegistryObject<Block> CHAIR_OAK = register("oak_chair", () -> new ChairBlock(Block.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> CHAIR_DARK_OAK = register("dark_oak_chair", () -> new ChairBlock(Block.Properties.copy(Blocks.DARK_OAK_PLANKS)));
    public static final RegistryObject<Block> LAPTOP_BLOCK = register("laptop_block", () -> new LaptopBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> UPGRADEDANVIL_BLOCK = register("upgradedanvil_block", () -> new UpgradedAnvilBlock(Block.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> PLATE_BLOCK = register("plate_block", () -> new PlateBlock(Block.Properties.copy(Blocks.GLASS_PANE)));
    public static final RegistryObject<Block> FOOTPLATE_BLOCK = register("footplate_block", () -> new FootPlateBlock(Block.Properties.copy(Blocks.GLASS_PANE)));
    public static final RegistryObject<Block> DECOBENCH_BLOCK = register("decobench_block", () -> new DecoBenchBlock(Block.Properties.copy(Blocks.GLASS_PANE)));
   
    private static RegistryObject<Block> register(String name, Supplier<Block> block) {
        return register(name, block, new Item.Properties().tab(DecoBlockTab.DECOBLOCK));
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, Item.Properties properties) {
        RegistryObject<Block> registryObject = REGISTER.register(name, block);
        ModItems.REGISTER.register(name, () -> new BlockItem(registryObject.get(), properties));
        return registryObject;
    }

    private static RegistryObject<Block> register(String name, Supplier<Block> block, @Nullable Function<RegistryObject<Block>, BlockItem> function) {
        RegistryObject<Block> registryObject = REGISTER.register(name, block);
        if(function != null) {
            ModItems.REGISTER.register(name, () -> function.apply(registryObject));
        }return registryObject;
    }

    private static RegistryObject<Block> registerNoItem(String name, Supplier<Block> block) {
        return REGISTER.register(name, block);
    }
}
