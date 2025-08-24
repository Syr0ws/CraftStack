package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.crafter.config.ConfigurationException;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.Glint;
import org.bukkit.configuration.ConfigurationSection;

public class YamlGlintComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "glint";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ConfigurationException {

        if(!section.isBoolean(PROPERTY_NAME)) {
            throw new ConfigurationException("Property '%s' is not a boolean at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        boolean glint = section.getBoolean(PROPERTY_NAME);

        return new Glint(glint);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.GLINT.getName();
    }
}
