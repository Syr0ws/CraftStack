package com.github.syr0ws.craftstack.loader.yaml;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.Lore;
import com.github.syr0ws.craftstack.loader.ItemComponentLoadingException;
import org.bukkit.configuration.ConfigurationSection;

import java.util.List;

public class YamlLoreComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "lore";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ItemComponentLoadingException {

        if(!section.isList(PROPERTY_NAME)) {
            throw new ItemComponentLoadingException("Property '%s' is not a list at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        List<String> lore = section.getStringList(PROPERTY_NAME);

        return new Lore(lore);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.LORE.getName();
    }
}
