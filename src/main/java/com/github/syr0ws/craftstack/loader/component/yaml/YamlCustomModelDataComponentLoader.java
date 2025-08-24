package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.crafter.config.ConfigurationException;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.CustomModelData;
import org.bukkit.configuration.ConfigurationSection;

public class YamlCustomModelDataComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "custom-model-data";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ConfigurationException {

        if (!section.isSet(PROPERTY_NAME)) {
            throw new ConfigurationException("Property '%s' is not an int at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        int customModelData = section.getInt(PROPERTY_NAME);

        return new CustomModelData(customModelData);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.CUSTOM_MODEL_DATA.getName();
    }
}
