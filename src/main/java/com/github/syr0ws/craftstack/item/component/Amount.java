package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.inventory.ItemStack;

/**
 * Component to change the amount of an {@link ItemStack}.
 */
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
    public void apply(ItemContext context) {
        context.getItemStack().setAmount(this.amount);
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
