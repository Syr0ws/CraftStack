package com.github.syr0ws.craftstack.component;

import com.github.syr0ws.craftstack.ItemComponent;
import com.github.syr0ws.craftstack.ItemComponentRegistry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class Amount implements ItemComponent {

    private int amount;

    public Amount(int amount) {
        this.setAmount(amount);
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        stack.setAmount(this.amount);
    }

    @Override
    public ItemComponent copy() {
        return new Amount(this.amount);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.AMOUNT.getName();
    }
}
