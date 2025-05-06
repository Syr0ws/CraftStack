package com.github.syr0ws.craftstack.loader.yaml;

import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import com.github.syr0ws.craftstack.component.Type;
import com.github.syr0ws.craftstack.loader.ItemComponentLoadingException;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;

public class TypeComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "type";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ItemComponentLoadingException {

        if (!section.isString(PROPERTY_NAME)) {
            throw new ItemComponentLoadingException("Property '%s' is not a string at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        String typeName = section.getString(PROPERTY_NAME);
        Material material = Material.matchMaterial(typeName);

        if (material == null) {
            throw new ItemComponentLoadingException("Unknown material '%s' at '%s'".formatted(typeName, section.getCurrentPath()));
        }

        return new Type(material);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.TYPE.getName();
    }
}
