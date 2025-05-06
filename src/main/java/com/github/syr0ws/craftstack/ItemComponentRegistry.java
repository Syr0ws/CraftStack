package com.github.syr0ws.craftstack;

public enum ItemComponentRegistry {

    TYPE,
    NAME,
    LORE,
    GLOW,
    AMOUNT,
    CUSTOM_MODEL_DATA,
    DAMAGE;

    public String getName() {
        return this.name();
    }
}
