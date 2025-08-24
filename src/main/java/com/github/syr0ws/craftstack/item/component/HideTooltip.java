package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;

/**
 * Component that hides the tooltip of an item.
 *
 * <p>Only available for 1.21+</p>
 */
public class HideTooltip implements ItemComponent {

    @Override
    public void apply(ItemContext context) {
        context.getItemMeta().setHideTooltip(true);
    }

    @Override
    public ItemComponent copy() {
        return new HideTooltip();
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.HIDE_TOOLTIP.getName();
    }
}
