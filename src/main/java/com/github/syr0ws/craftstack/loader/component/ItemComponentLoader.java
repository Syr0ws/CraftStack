package com.github.syr0ws.craftstack.loader.component;

import com.github.syr0ws.craftstack.item.ItemComponent;

/**
 * Loader interface to create {@link ItemComponent} instances from a data source.
 *
 * @param <T> the data source type
 */
public interface ItemComponentLoader<T> {

    /**
     * Loads an {@link ItemComponent} from the given data source.
     *
     * @param dataSource the data source
     * @return loaded {@link ItemComponent}
     * @throws ItemComponentException if the component cannot be loaded
     */
    ItemComponent loadItemComponent(T dataSource) throws ItemComponentException;

    /**
     * Checks whether this loader can load from the given data source.
     *
     * @param dataSource the data source
     * @return {@code true} if this loader can load from the data source, {@code false} otherwise
     * @throws ItemComponentException if the check fails
     */
    boolean canLoad(T dataSource) throws ItemComponentException;

    /**
     * Returns the name of the component this loader handles.
     *
     * @return component name
     */
    String getComponentName();
}
