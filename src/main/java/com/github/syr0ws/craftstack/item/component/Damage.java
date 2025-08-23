package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;

/**
 * Component to change the durability of an {@link ItemStack}.
 */
public class Damage implements ItemComponent {

    private int damage;

    public Damage(int damage) {
        this.setDamage(damage);
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public void apply(ItemContext context) {

        if (!(context.getItemMeta() instanceof Damageable damageable)) {
            throw new IllegalStateException("ItemMeta is not a Damageable");
        }

        damageable.setDamage(this.damage);
    }

    @Override
    public ItemComponent copy() {
        return new Damage(this.damage);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.DAMAGE.getName();
    }
}
