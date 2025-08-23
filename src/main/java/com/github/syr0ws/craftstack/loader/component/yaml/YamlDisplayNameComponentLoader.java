package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.DisplayName;
import com.github.syr0ws.craftstack.loader.component.ItemComponentException;
import org.bukkit.configuration.ConfigurationSection;

public class YamlDisplayNameComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "display-name";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ItemComponentException {

        if (!section.isString(PROPERTY_NAME)) {
            throw new ItemComponentException("Property '%s' is not a string at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        String displayName = section.getString(PROPERTY_NAME);

        return new DisplayName(displayName);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.DISPLAY_NAME.getName();
    }
}
