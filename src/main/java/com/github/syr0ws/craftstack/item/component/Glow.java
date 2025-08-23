package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Component to add a glowing (e.g. enchanting) effect to an {@link ItemStack}.
 */
public class Glow implements ItemComponent {

    @Override
    public void apply(ItemContext context) {
        ItemMeta meta = context.getItemMeta();
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
