package com.danizml.decoblock.core;

import java.util.function.Supplier;

import com.danizml.decoblock.DecoBlock;

import net.minecraft.world.item.Item;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

@SuppressWarnings("all")
public class ModItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, DecoBlock.MOD_ID);

    public static final RegistryObject<Item> DECOCOMPONENT = register("decocomponent",() ->
            new Item(new Item.Properties().tab(DecoBlockTab.DECOBLOCK)));
    public static final RegistryObject<Item> HAMMER = register("hammer",() ->
            new Item(new Item.Properties().tab(DecoBlockTab.DECOBLOCK)));
    public static final RegistryObject<Item> MOUNTAINRANGE = register("mountainrange",() ->
            new Item(new Item.Properties().tab(DecoBlockTab.DECOBLOCK)));

    private static RegistryObject<Item> register(String name, Supplier<Item> item) {
        return REGISTER.register(name, item);
    }
}
