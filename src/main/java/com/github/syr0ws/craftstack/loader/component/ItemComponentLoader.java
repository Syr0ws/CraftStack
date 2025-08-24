package com.github.syr0ws.craftstack.loader.component;

import com.github.syr0ws.crafter.config.ConfigurationException;
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
     * @throws ConfigurationException if the component cannot be loaded
     */
    ItemComponent loadItemComponent(T dataSource) throws ConfigurationException;

    /**
     * Checks whether this loader can load from the given data source.
     *
     * @param dataSource the data source
     * @return {@code true} if this loader can load from the data source, {@code false} otherwise
     * @throws ConfigurationException if the check fails
     */
    boolean canLoad(T dataSource) throws ConfigurationException;

    /**
     * Returns the name of the component this loader handles.
     *
     * @return component name
     */
    String getComponentName();
}
