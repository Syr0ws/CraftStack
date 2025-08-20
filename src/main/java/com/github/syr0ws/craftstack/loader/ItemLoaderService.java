package com.github.syr0ws.craftstack.loader;

import com.github.syr0ws.craftstack.item.Item;
import com.github.syr0ws.craftstack.loader.component.ItemComponentLoader;

import java.util.List;

/**
 * Service interface to load {@link Item} objects from a data source.
 *
 * @param <T> the data source type
 */
public interface ItemLoaderService<T> {

    /**
     * Loads a single {@link Item} from the given data source.
     *
     * @param dataSource the data source
     * @return loaded {@link Item}
     * @throws ItemException if the item cannot be loaded
     */
    Item load(T dataSource) throws ItemException;

    /**
     * Loads all {@link Item} instances from the given data source.
     *
     * @param dataSource the data source
     * @return list of loaded items
     * @throws ItemException if the items cannot be loaded
     */
    List<Item> loadAll(T dataSource) throws ItemException;

    /**
     * Adds an {@link ItemComponentLoader} to this service.
     *
     * @param loader the loader to add
     */
    void addLoader(ItemComponentLoader<T> loader);

    /**
     * Checks if the given loader is registered.
     *
     * @param loader the loader to check
     * @return {@code true} if the loader is registered, {@code false} otherwise
     */
    boolean hasLoader(ItemComponentLoader<T> loader);

    /**
     * Returns the loader for the given component name.
     *
     * @param componentName the component name
     * @return the loader, or {@code null} if not found
     */
    ItemComponentLoader<T> getLoader(String componentName);

    /**
     * Returns all registered loaders.
     *
     * @return list of loaders
     */
    List<ItemComponentLoader<T>> getLoaders();

    /**
     * Returns the type of the data source this service supports.
     *
     * @return data source type
     */
    Class<T> getDataSourceType();
}
