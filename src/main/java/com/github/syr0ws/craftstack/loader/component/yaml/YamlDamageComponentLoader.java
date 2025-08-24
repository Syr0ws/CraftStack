package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.crafter.config.ConfigurationException;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.Damage;
import org.bukkit.configuration.ConfigurationSection;

public class YamlDamageComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "damage";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ConfigurationException {

        if (!section.isInt(PROPERTY_NAME)) {
            throw new ConfigurationException("Property '%s' is not an int at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        int amount = section.getInt(PROPERTY_NAME);

        return new Damage(amount);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.DAMAGE.getName();
    }
}
