package com.github.syr0ws.craftstack.loader.component;

import java.io.IOException;

public class ItemComponentException extends IOException {

    public ItemComponentException(String message) {
        super(message);
    }

    public ItemComponentException(String message, Throwable cause) {
        super(message, cause);
    }
}
