package com.github.syr0ws.craftstack.item;

import com.github.syr0ws.crafter.util.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

public class Item {

    private final Material material;
    private final Map<String, ItemComponent> components = new HashMap<>();

    private Item(Material material) {
        Validate.notNull(material, "material cannot be null");
        this.material = material;
    }

    public Item addComponent(ItemComponent component) {
        Validate.notNull(component, "component cannot be null");
        this.components.put(component.getName(), component);
        return this;
    }

    public void addComponents(ItemComponent... components) {
        Validate.notNull(components, "components cannot be null");
        Arrays.stream(components).filter(Objects::nonNull).forEach(this::addComponent);
    }

    public void addComponents(Collection<ItemComponent> components) {
        Validate.notNull(components, "components cannot be null");
        components.stream().filter(Objects::nonNull).forEach(this::addComponent);
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
        return List.copyOf(this.components.values());
    }

    public ItemStack build() {

        ItemStack stack = new ItemStack(this.material);

        // Retrieving the ItemMeta once to avoid multiple copies.
        ItemMeta meta = stack.getItemMeta();

        // Applying components.
        this.components.values().forEach(component -> component.apply(stack, meta));

        // Applying the modified ItemMeta to the item.
        stack.setItemMeta(meta);

        return stack;
    }

    public static Item create(Material material) {
        return new Item(material);
    }
}
