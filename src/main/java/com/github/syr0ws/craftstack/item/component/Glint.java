package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.inventory.ItemStack;

/**
 * Component to toggle the glint effect of an {@link ItemStack}.
 */
public class Glint implements ItemComponent {

    private boolean glint;

    /**
     * Creates a new glint component.
     *
     * @param glint whether the item should have a glint
     */
    public Glint(boolean glint) {
        this.glint = glint;
    }

    /**
     * Returns whether the glint is enabled.
     *
     * @return {@code true} if glint is enabled
     */
    public boolean hasGlint() {
        return glint;
    }

    /**
     * Sets whether the glint is enabled.
     *
     * @param glint {@code true} to enable glint
     */
    public void setGlint(boolean glint) {
        this.glint = glint;
    }

    @Override
    public void apply(ItemContext context) {
        context.getItemMeta().setEnchantmentGlintOverride(this.glint);
    }

    @Override
    public ItemComponent copy() {
        return new Glint(this.glint);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.GLINT.getName();
    }
}
