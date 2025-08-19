package com.github.syr0ws.craftstack.item;

public enum ItemComponentRegistry {

    TYPE,
    DISPLAY_NAME,
    LORE,
    GLOW,
    AMOUNT,
    CUSTOM_MODEL_DATA,
    DAMAGE;

    public String getName() {
        return this.name();
    }
}
