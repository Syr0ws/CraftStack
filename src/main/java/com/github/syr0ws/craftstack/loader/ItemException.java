package com.github.syr0ws.craftstack.loader;

/**
 * Thrown to indicate a general error while loading or handling an Item.
 */
public class ItemException extends Exception {

    /**
     * @see Exception#Exception(String)
     */
    public ItemException(String message) {
        super(message);
    }

    /**
     * @see Exception#Exception(String, Throwable)
     */
    public ItemException(String message, Throwable cause) {
        super(message, cause);
    }
}
