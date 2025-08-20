package com.github.syr0ws.craftstack.item;

import com.github.syr0ws.crafter.util.Validate;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.*;

/**
 * Represents a customizable item with a base {@link Material} and a set of {@link ItemComponent}.
 */
public class Item {

    private final Material material;
    private final Map<String, ItemComponent> components = new HashMap<>();

    private Item(Material material) {
        Validate.notNull(material, "material cannot be null");
        this.material = material;
    }

    /**
     * Adds a component to this item.
     *
     * @param component the {@link ItemComponent} to add
     * @return this item for chaining method calls
     */
    public Item addComponent(ItemComponent component) {
        Validate.notNull(component, "component cannot be null");
        this.components.put(component.getName(), component);
        return this;
    }

    /**
     * Adds multiple components to this item.
     *
     * @param components the components to add
     */
    public void addComponents(ItemComponent... components) {
        Validate.notNull(components, "components cannot be null");
        Arrays.stream(components).filter(Objects::nonNull).forEach(this::addComponent);
    }

    /**
     * Adds multiple components to this item.
     *
     * @param components the components to add
     */
    public void addComponents(Collection<ItemComponent> components) {
        Validate.notNull(components, "components cannot be null");
        components.stream().filter(Objects::nonNull).forEach(this::addComponent);
    }

    /**
     * Removes a component by name.
     *
     * @param componentName the name of the component to remove
     * @return {@code true} if the component was removed, {@code false} otherwise
     */
    public boolean removeComponent(String componentName) {
        Validate.notNull(componentName, "componentName cannot be null");
        return this.components.remove(componentName) != null;
    }

    /**
     * Checks if a component exists by name.
     *
     * @param componentName the name of the component to check
     * @return {@code true} if the component exists, {@code false} otherwise
     */
    public boolean hasComponent(String componentName) {
        Validate.notNull(componentName, "componentName cannot be null");
        return this.components.containsKey(componentName);
    }

    /**
     * Returns an immutable list of components associated with this item.
     *
     * @return list of {@link ItemComponent}
     */
    public List<ItemComponent> getComponents() {
        return List.copyOf(this.components.values());
    }

    /**
     * Creates a deep copy of this item.
     *
     * @return a new {@link Item} with copied components
     */
    public Item copy() {

        Item copy = new Item(this.material);

        List<ItemComponent> components = this.components.values().stream()
                .map(ItemComponent::copy)
                .toList();

        copy.addComponents(components);

        return copy;
    }

    /**
     * Creates an {@link ItemStack} from the current item.
     *
     * @return a new {@link ItemStack}
     */
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

    /**
     * Creates a new item with the given material.
     *
     * @param material the base {@link Material}
     * @return a new {@link Item}
     */
    public static Item create(Material material) {
        return new Item(material);
    }
}
