package com.github.syr0ws.craftstack.item;

/**
 * Represents a property that can be applied to an {@link Item}.
 */
public interface ItemComponent {

    /**
     * Applies this component using the given context.
     *
     * @param context the item context
     */
    void apply(ItemContext context);

    /**
     * Creates a copy of this component.
     *
     * @return a new {@link ItemComponent}
     */
    ItemComponent copy();

    /**
     * Returns the name of this component.
     *
     * @return component name
     */
    String getName();
}
