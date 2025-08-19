package com.github.syr0ws.craftstack.loader.yaml;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.loader.ItemComponentLoader;
import com.github.syr0ws.craftstack.loader.ItemComponentLoaderService;
import org.bukkit.configuration.ConfigurationSection;

import java.util.*;

public class YamlItemComponentLoaderService implements ItemComponentLoaderService<ConfigurationSection> {

    private final Map<String, ItemComponentLoader<ConfigurationSection>> loaders = new HashMap<>();

    @Override
    public void addLoader(ItemComponentLoader<ConfigurationSection> loader) {
        Validate.notNull(loader, "loader cannot be null");
        this.loaders.put(loader.getComponentName(), loader);
    }

    @Override
    public boolean hasLoader(ItemComponentLoader<ConfigurationSection> loader) {
        Validate.notNull(loader, "loader cannot be null");
        return this.loaders.containsKey(loader.getComponentName());
    }

    @Override
    public ItemComponentLoader<ConfigurationSection> getLoader(String componentName) {
        Validate.notEmpty(componentName, "componentName cannot be null or empty");
        return this.loaders.get(componentName);
    }

    @Override
    public List<ItemComponentLoader<ConfigurationSection>> getLoaders() {
        return List.copyOf(this.loaders.values());
    }

    @Override
    public Class<ConfigurationSection> getDataSourceType() {
        return ConfigurationSection.class;
    }
}
