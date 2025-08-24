package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.NamespacedKey;

public class TooltipStyle implements ItemComponent {

    private NamespacedKey namespacedKey;

    public TooltipStyle(NamespacedKey namespacedKey) {
        this.setNamespacedKey(namespacedKey);
    }

    public NamespacedKey getNamespacedKey() {
        return this.namespacedKey;
    }

    public void setNamespacedKey(NamespacedKey namespacedKey) {
        Validate.notNull(namespacedKey, "namespacedKey cannot be null");
        this.namespacedKey = namespacedKey;
    }

    @Override
    public void apply(ItemContext context) {
        context.getItemMeta().setTooltipStyle(this.namespacedKey);
    }

    @Override
    public ItemComponent copy() {
        return new TooltipStyle(this.namespacedKey);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.TOOLTIP_STYLE.getName();
    }
}
