package com.danizml.decoblock.core;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

import javax.annotation.Nonnull;

public class DecoBlockTab {
    public static final CreativeModeTab DECOBLOCK = new CreativeModeTab("DecoBlock") {
        @Override
        @Nonnull
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.DECOCOMPONENT.get());
        }
    };
}
