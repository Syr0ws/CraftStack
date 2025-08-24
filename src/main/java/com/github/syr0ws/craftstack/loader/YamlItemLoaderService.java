package com.github.syr0ws.craftstack.loader;

import com.github.syr0ws.crafter.config.ConfigurationException;
import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.Item;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.loader.component.ItemComponentLoader;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class YamlItemLoaderService implements ItemLoaderService<ConfigurationSection> {

    private final Map<String, ItemComponentLoader<ConfigurationSection>> loaders = new HashMap<>();

    @Override
    public Item load(ConfigurationSection section) throws ConfigurationException {

        Material material = this.loadMaterial(section);
        List<ItemComponent> components = this.loadComponents(section);

        Item item = Item.create(material);
        item.addComponents(components);

        return item;
    }

    @Override
    public List<Item> loadAll(ConfigurationSection section) throws ConfigurationException {

        List<Item> items = new ArrayList<>();

        for (String key : section.getKeys(false)) {

            ConfigurationSection itemSection = section.getConfigurationSection(key);

            if (itemSection == null) {
                continue;
            }

            Item item = this.load(itemSection);
            items.add(item);
        }

        return items;
    }

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

    private Material loadMaterial(ConfigurationSection section) throws ConfigurationException {

        String propertyName = "type";

        if (!section.isString(propertyName)) {
            throw new ConfigurationException("Property '%s' not found or is not a string at '%s'".formatted(propertyName, section.getCurrentPath()));
        }

        String type = section.getString(propertyName, "");
        Material material = Material.matchMaterial(type);

        if (material == null) {
            throw new ConfigurationException("Invalid type '%s' at '%s'".formatted(type, section.getCurrentPath()));
        }

        return material;
    }

    private List<ItemComponent> loadComponents(ConfigurationSection section) throws ConfigurationException {

        List<ItemComponent> components = new ArrayList<>();

        for (ItemComponentLoader<ConfigurationSection> loader : this.loaders.values()) {

            if (loader.canLoad(section)) {
                ItemComponent component = loader.loadItemComponent(section);
                components.add(component);
            }
        }

        return components;
    }
}
