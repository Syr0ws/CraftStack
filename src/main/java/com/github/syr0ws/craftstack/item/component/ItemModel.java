package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.NamespacedKey;

/**
 * Component that assigns a custom item model.
 *
 * <p>Only available for 1.21+</p>
 */
public class ItemModel implements ItemComponent {

    private NamespacedKey namespacedKey;

    /**
     * Creates a new {@code ItemModel}.
     *
     * @param namespacedKey the namespaced key for the item model
     */
    public ItemModel(NamespacedKey namespacedKey) {
        this.setNamespacedKey(namespacedKey);
    }

    /**
     * Gets the {@link NamespacedKey} for this item model.
     *
     * @return the namespaced key
     */
    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

    /**
     * Sets the {@link NamespacedKey} for this item model.
     *
     * @param namespacedKey the namespaced key to set
     */
    public void setNamespacedKey(NamespacedKey namespacedKey) {
        Validate.notNull(namespacedKey, "namespacedKey cannot be null");
        this.namespacedKey = namespacedKey;
    }

    @Override
    public void apply(ItemContext context) {
        context.getItemMeta().setItemModel(this.namespacedKey);
    }

    @Override
    public ItemComponent copy() {
        return new ItemModel(this.namespacedKey);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.ITEM_MODEL.getName();
    }
}
