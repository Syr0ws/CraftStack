package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.HideTooltip;
import org.bukkit.configuration.ConfigurationSection;

public class YamlHideTooltipComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "hide-tooltip";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) {
        return new HideTooltip();
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.getBoolean(PROPERTY_NAME, false);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.HIDE_TOOLTIP.getName();
    }
}
