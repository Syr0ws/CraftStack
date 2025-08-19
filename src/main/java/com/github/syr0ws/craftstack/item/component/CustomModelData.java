package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class CustomModelData implements ItemComponent {

    private int customModelData;

    public CustomModelData(int customModelData) {
        this.customModelData = customModelData;
    }

    public int getCustomModelData() {
        return customModelData;
    }

    public void setCustomModelData(int customModelData) {
        this.customModelData = customModelData;
    }

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        meta.setCustomModelData(this.customModelData);
    }

    @Override
    public ItemComponent copy() {
        return new CustomModelData(this.customModelData);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.CUSTOM_MODEL_DATA.getName();
    }
}
