package com.github.syr0ws.craftstack.item;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.placeholder.PlaceholderContext;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Optional;

/**
 * Context for {@link ItemStack} building.
 */
public class ItemContext {

    private final PlaceholderContext placeholderContext;
    private final ItemStack stack;
    private final ItemMeta meta;

    /**
     * Creates a new context for the given {@link ItemStack}.
     *
     * @param stack the item stack
     * @param placeholderContext the placeholder context, may be {@code null}
     */
    public ItemContext(ItemStack stack, PlaceholderContext placeholderContext) {
        Validate.notNull(stack, "stack cannot be null");

        this.stack = stack;
        this.meta = stack.getItemMeta();
        this.placeholderContext = placeholderContext;
    }

    /**
     * Gets the {@link ItemStack} stored in the context.
     *
     * @return the {@link ItemStack}
     */
    public ItemStack getItemStack() {
        return this.stack;
    }

    /**
     * Gets the {@link ItemMeta} associated with the current {@link ItemStack}.
     *
     * @return the {@link ItemMeta}
     */
    public ItemMeta getItemMeta() {
        return this.meta;
    }

    /**
     * Returns the placeholder context if present.
     *
     * @return optional placeholder context
     */
    public Optional<PlaceholderContext> getPlaceholderContext() {
        return Optional.ofNullable(this.placeholderContext);
    }
}
