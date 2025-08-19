package com.github.syr0ws.craftstack.loader.component;

import com.github.syr0ws.craftstack.loader.ItemException;

public class ItemComponentException extends ItemException {

    public ItemComponentException(String message) {
        super(message);
    }

    public ItemComponentException(String message, Throwable cause) {
        super(message, cause);
    }
}
