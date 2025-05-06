package com.github.syr0ws.craftstack.component;

import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Glow implements ItemComponent {

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        meta.addEnchant(Enchantment.DURABILITY, 1, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
    }

    @Override
    public ItemComponent copy() {
        return new Glow();
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.GLOW.getName();
    }
}
