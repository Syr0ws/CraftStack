package com.github.syr0ws.craftstack.component;

import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

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
    public void apply(ItemStack stack, ItemMeta meta) {

        if(!(meta instanceof Damageable damageable)) {
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
