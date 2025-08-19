package com.github.syr0ws.craftstack.component;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Type implements ItemComponent {

    private Material material;

    public Type(Material material) {
        this.setMaterial(material);
    }

    public Material getMaterial() {
        return this.material;
    }

    public void setMaterial(Material material) {
        Validate.notNull(material, "material cannot be null");
        this.material = material;
    }

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        stack.setType(this.material);
    }

    @Override
    public ItemComponent copy() {
        return new Type(this.material);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.TYPE.getName();
    }
}
