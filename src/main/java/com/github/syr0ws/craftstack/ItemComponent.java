package com.github.syr0ws.craftstack;

import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public interface ItemComponent {

    void apply(ItemStack stack, ItemMeta meta);

    ItemComponent copy();

    String getName();
}
