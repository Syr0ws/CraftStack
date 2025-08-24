package com.github.syr0ws.craftstack;

import com.github.syr0ws.craftstack.loader.ItemLoaderService;
import com.github.syr0ws.craftstack.loader.YamlItemLoaderService;
import com.github.syr0ws.craftstack.loader.component.yaml.YamlComponentLoaderRegistry;
import org.bukkit.configuration.ConfigurationSection;

/**
 * Global class with default behaviors for the CraftStack library.
 */
public class CraftStack {

    /**
     * Returns a preconfigured {@link ItemLoaderService} using YAML as the data source,
     * with standard ItemComponentLoader instances already registered.
     *
     * @return a configured {@link ItemLoaderService} that handles YAML as data source
     */
    public static ItemLoaderService<ConfigurationSection> getDefaultItemLoader() {

        ItemLoaderService<ConfigurationSection> service = new YamlItemLoaderService();

        for(YamlComponentLoaderRegistry registry : YamlComponentLoaderRegistry.values()) {
            service.addLoader(registry.getLoader());
        }

        return service;
    }
}
