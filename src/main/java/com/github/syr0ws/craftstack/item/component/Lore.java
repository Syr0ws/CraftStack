package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.text.TextUtil;
import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Lore implements ItemComponent {

    private final List<String> lore = new ArrayList<>();

    public Lore(List<String> lore) {
        this.setLore(lore);
    }

    public Lore(String... lore) {
        this.setLore(lore);
    }

    public List<String> getLore() {
        return Collections.unmodifiableList(this.lore);
    }

    public void setLore(List<String> lore) {
        Validate.notNull(lore, "lore cannot be null");
        this.lore.clear();
        this.lore.addAll(TextUtil.parseColors(lore));
    }

    public void setLore(String... lore) {
        Validate.notNull(lore, "lore cannot be null");
        this.setLore(List.of(lore));
    }

    @Override
    public void apply(ItemStack stack, ItemMeta meta) {
        List<String> lore = TextUtil.parseColors(this.lore);
        meta.setLore(lore);
    }

    @Override
    public ItemComponent copy() {
        return new Lore(this.lore);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.LORE.getName();
    }
}
