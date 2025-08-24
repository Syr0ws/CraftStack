package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.NamespacedKey;

/**
 * Component that assigns a tooltip style to an item.
 *
 * <p>Only available for 1.21+</p>
 */
public class TooltipStyle implements ItemComponent {

    private NamespacedKey namespacedKey;

    /**
     * Creates a new {@code TooltipStyle}.
     *
     * @param namespacedKey the namespaced key for the tooltip style
     */
    public TooltipStyle(NamespacedKey namespacedKey) {
        this.setNamespacedKey(namespacedKey);
    }

    /**
     * Gets the {@link NamespacedKey} for this tooltip style.
     *
     * @return the namespaced key
     */
    public NamespacedKey getNamespacedKey() {
        return this.namespacedKey;
    }

    /**
     * Sets the {@link NamespacedKey} for this tooltip style.
     *
     * @param namespacedKey the namespaced key to set
     */
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
