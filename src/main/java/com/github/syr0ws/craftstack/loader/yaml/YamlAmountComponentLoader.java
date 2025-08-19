package com.github.syr0ws.craftstack.loader.yaml;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.component.Amount;
import com.github.syr0ws.craftstack.loader.ItemComponentLoadingException;
import org.bukkit.configuration.ConfigurationSection;

public class YamlAmountComponentLoader extends YamlItemComponentLoader {

    private static final String PROPERTY_NAME = "amount";

    @Override
    public ItemComponent loadItemComponent(ConfigurationSection section) throws ItemComponentLoadingException {

        if(!section.isInt(PROPERTY_NAME)) {
            throw new ItemComponentLoadingException("Property '%s' is not an int at '%s'".formatted(PROPERTY_NAME, section.getCurrentPath()));
        }

        int amount = section.getInt(PROPERTY_NAME);

        return new Amount(amount);
    }

    @Override
    public boolean canLoad(ConfigurationSection section) {
        return section.isSet(PROPERTY_NAME);
    }

    @Override
    public String getComponentName() {
        return ItemComponentRegistry.AMOUNT.getName();
    }
}
