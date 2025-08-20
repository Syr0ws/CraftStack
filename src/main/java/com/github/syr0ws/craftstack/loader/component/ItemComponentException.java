package com.github.syr0ws.craftstack.loader.component;

import com.github.syr0ws.craftstack.loader.ItemException;

/**
 * Thrown to indicate an error while loading or handling an ItemComponent.
 */
public class ItemComponentException extends ItemException {

    /**
     * @see ItemException#ItemException(String)
     */
    public ItemComponentException(String message) {
        super(message);
    }

    /**
     * @see ItemException#ItemException(String, Throwable)
     */
    public ItemComponentException(String message, Throwable cause) {
        super(message, cause);
    }
}
