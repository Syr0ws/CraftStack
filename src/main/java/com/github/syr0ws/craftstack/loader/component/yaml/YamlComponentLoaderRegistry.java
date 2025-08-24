package com.github.syr0ws.craftstack.loader.component.yaml;

import com.github.syr0ws.craftstack.loader.component.ItemComponentLoader;
import org.bukkit.configuration.ConfigurationSection;

public enum YamlComponentLoaderRegistry {

    DISPLAY_NAME(new YamlDisplayNameComponentLoader()),
    LORE(new YamlLoreComponentLoader()),
    CUSTOM_MODEL_DATA(new YamlCustomModelDataComponentLoader()),
    GLOW(new YamlGlowComponentLoader()),
    GLINT(new YamlGlintComponentLoader()),
    AMOUNT(new YamlAmountComponentLoader()),
    DAMAGE(new YamlDamageComponentLoader()),
    HIDE_TOOLTIP(new YamlHideTooltipComponentLoader()),
    TOOLTIP_STYLE(new YamlTooltipStyleComponentLoader()),
    ITEM_MODEL(new YamlItemModelComponentLoader());

    private final ItemComponentLoader<ConfigurationSection> loader;

    YamlComponentLoaderRegistry(ItemComponentLoader<ConfigurationSection> loader) {
        this.loader = loader;
    }

    public ItemComponentLoader<ConfigurationSection> getLoader() {
        return this.loader;
    }
}
