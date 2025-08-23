package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.text.TextUtil;
import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Component to change the lore of an {@link ItemStack}.
 */
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
    public void apply(ItemContext context) {

        List<String> lore = context.getPlaceholderContext()
                .map(pctx -> pctx.parseAll(this.lore))
                .orElse(this.lore);

        lore = TextUtil.parseColors(lore);

        context.getItemMeta().setLore(lore);
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
