package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.NamespacedKey;
import org.bukkit.Registry;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

/**
 * Component to add a glowing (e.g. enchanting) effect to an {@link ItemStack}.
 *
 * <p><strong>Note:</strong> This component should only be used on versions below 1.21.
 * For 1.21 and above, use the {@link Glint} component instead.</p>
 */
public class Glow implements ItemComponent {

    private static final Enchantment ENCHANTMENT = Registry.ENCHANTMENT.get(NamespacedKey.minecraft("unbreaking"));

    @Override
    public void apply(ItemContext context) {
        ItemMeta meta = context.getItemMeta();
        meta.addEnchant(ENCHANTMENT, 1, false);
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
