package com.github.syr0ws.craftstack.component;

import com.github.syr0ws.crafter.text.TextUtil;
import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class DisplayName implements ItemComponent {

    private String displayName;

    public DisplayName(String displayName) {
        this.setDisplayName(displayName);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        Validate.notNull(displayName, "displayName cannot be null");
        this.displayName = TextUtil.parseColors(displayName);
    }

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        meta.setDisplayName(this.displayName);
    }

    @Override
    public ItemComponent copy() {
        return new DisplayName(this.displayName);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.NAME.getName();
    }
}
