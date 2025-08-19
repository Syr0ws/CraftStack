package com.github.syr0ws.craftstack.loader.yaml;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.Glow;
import com.github.syr0ws.craftstack.loader.ItemComponentLoadingException;
import org.bukkit.configuration.ConfigurationSection;

public class YamlGlowComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "glow";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ItemComponentLoadingException {
        return new Glow();
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.getBoolean(PROPERTY_NAME, false);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.GLOW.getName();
    }
}
