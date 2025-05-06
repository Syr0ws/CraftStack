package com.github.syr0ws.craftstack.loader;

import java.io.IOException;

public class ItemComponentLoadingException extends IOException {

    public ItemComponentLoadingException(String message) {
        super(message);
    }

    public ItemComponentLoadingException(String message, Throwable cause) {
        super(message, cause);
    }
}
