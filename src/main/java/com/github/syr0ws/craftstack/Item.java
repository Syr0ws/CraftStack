package com.github.syr0ws.craftstack;

import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.component.Type;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Item {

    private final Map<String, ItemComponent> components = new HashMap<>();

    public ItemStack build() {

        ItemStack stack = new ItemStack(Material.AIR);

        // Starting by applying the type component to fix the ItemMeta.
        // This must be done if we want to avoid ItemMeta copy for each component to save performances.
        this.components.get(ItemComponentRegistry.TYPE.getName()).apply(stack, stack.getItemMeta());

        ItemMeta meta = stack.getItemMeta();
        List<ItemComponent> components = this.getComponents();

        // Removing the type component which has already been handled.
        components.removeIf(component -> component.getName().equals(ItemComponentRegistry.TYPE.getName()));

        // Applying components.
        components.forEach(component -> component.apply(stack, meta));
        stack.setItemMeta(meta);

        return stack;
    }

    public Item addComponent(ItemComponent component) {
        Validate.notNull(component, "component cannot be null");
        this.components.put(component.getName(), component);
        return this;
    }

    public boolean removeComponent(String componentName) {
        Validate.notNull(componentName, "componentName cannot be null");
        return this.components.remove(componentName) != null;
    }

    public boolean hasComponent(String componentName) {
        Validate.notNull(componentName, "componentName cannot be null");
        return this.components.containsKey(componentName);
    }

    public List<ItemComponent> getComponents() {
        return new ArrayList<>(this.components.values());
    }

    public static Item create(Type type) {
        Validate.notNull(type, "type component cannot be null");
        return new Item().addComponent(type);
    }
}
