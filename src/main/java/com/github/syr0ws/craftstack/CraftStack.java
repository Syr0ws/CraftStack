package com.github.syr0ws.craftstack;

import com.github.syr0ws.craftstack.loader.ItemComponentLoaderService;
import com.github.syr0ws.craftstack.loader.yaml.*;
import org.bukkit.configuration.ConfigurationSection;

public class CraftStack {

    public static ItemComponentLoaderService<ConfigurationSection> getDefaultComponentLoaderService() {

        ItemComponentLoaderService<ConfigurationSection> service = new YamlItemComponentLoaderService();
        service.addLoader(new YamlDisplayNameComponentLoader());
        service.addLoader(new YamlLoreComponentLoader());
        service.addLoader(new YamlCustomModelDataComponentLoader());
        service.addLoader(new YamlGlowComponentLoader());
        service.addLoader(new YamlAmountComponentLoader());
        service.addLoader(new YamlDamageComponentLoader());

        return service;
    }
}
