package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.NamespacedKey;

public class ItemModel implements ItemComponent {

    private NamespacedKey namespacedKey;

    public ItemModel(NamespacedKey namespacedKey) {
        this.setNamespacedKey(namespacedKey);
    }

    public NamespacedKey getNamespacedKey() {
        return namespacedKey;
    }

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
