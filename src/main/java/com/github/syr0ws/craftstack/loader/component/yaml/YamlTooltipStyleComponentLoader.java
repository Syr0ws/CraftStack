package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.crafter.config.ConfigUtil;
import com.github.syr0ws.crafter.config.ConfigurationException;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.TooltipStyle;
import org.bukkit.NamespacedKey;
import org.bukkit.configuration.ConfigurationSection;

public class YamlTooltipStyleComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "tooltip-style";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ConfigurationException {

        if (!section.isString(PROPERTY_NAME)) {
            throw new ConfigurationException("Property '%s' is not a string at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        NamespacedKey namespacedKey = ConfigUtil.getNamespacedKey(section, PROPERTY_NAME);

        return new TooltipStyle(namespacedKey);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.TOOLTIP_STYLE.getName();
    }
}
