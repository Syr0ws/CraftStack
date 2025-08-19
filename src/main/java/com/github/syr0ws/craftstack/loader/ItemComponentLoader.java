package com.github.syr0ws.craftstack.loader;

import com.github.syr0ws.craftstack.item.ItemComponent;

public interface ItemComponentLoader<T> {

    ItemComponent loadItemComponent(T dataSource) throws ItemComponentLoadingException;

    boolean canLoad(T dataSource) throws ItemComponentLoadingException;

    String getComponentName();
}
