package com.github.syr0ws.craftstack;

import com.github.syr0ws.craftstack.loader.ItemLoaderService;
import com.github.syr0ws.craftstack.loader.YamlItemLoaderService;
import com.github.syr0ws.craftstack.loader.component.yaml.*;
import org.bukkit.configuration.ConfigurationSection;

public class CraftStack {

    public static ItemLoaderService<ConfigurationSection> getDefaultComponentLoaderService() {

        ItemLoaderService<ConfigurationSection> service = new YamlItemLoaderService();
        service.addLoader(new YamlDisplayNameComponentLoader());
        service.addLoader(new YamlLoreComponentLoader());
        service.addLoader(new YamlCustomModelDataComponentLoader());
        service.addLoader(new YamlGlowComponentLoader());
        service.addLoader(new YamlAmountComponentLoader());
        service.addLoader(new YamlDamageComponentLoader());

        return service;
    }
}
