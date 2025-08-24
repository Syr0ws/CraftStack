package com.github.syr0ws.craftstack.item;

/**
 * Registry for common {@link ItemComponent} types.
 */
public enum ItemComponentRegistry {

    TYPE,
    DISPLAY_NAME,
    LORE,
    GLOW,
    GLINT,
    AMOUNT,
    CUSTOM_MODEL_DATA,
    DAMAGE,
    HIDE_TOOLTIP,
    TOOLTIP_STYLE,
    ITEM_MODEL;

    /**
     * Returns the name of this component registry entry.
     *
     * @return component name
     */
    public String getName() {
        return this.name();
    }
}
