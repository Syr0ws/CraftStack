package com.github.syr0ws.craftstack.loader;

import com.github.syr0ws.craftstack.item.Item;
import com.github.syr0ws.craftstack.loader.component.ItemComponentLoader;

import java.util.List;

public interface ItemLoaderService<T> {

    Item load(T dataSource) throws ItemException;

    List<Item> loadAll(T datasource) throws ItemException;

    void addLoader(ItemComponentLoader<T> loader);

    boolean hasLoader(ItemComponentLoader<T> loader);

    ItemComponentLoader<T> getLoader(String componentName);

    List<ItemComponentLoader<T>> getLoaders();

    Class<T> getDataSourceType();
}
