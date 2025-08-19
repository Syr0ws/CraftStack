package com.github.syr0ws.craftstack.loader.component;

import com.github.syr0ws.craftstack.item.ItemComponent;

public interface ItemComponentLoader<T> {

    ItemComponent loadItemComponent(T dataSource) throws ItemComponentException;

    boolean canLoad(T dataSource) throws ItemComponentException;

    String getComponentName();
}
