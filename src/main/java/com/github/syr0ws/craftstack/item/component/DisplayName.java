package com.github.syr0ws.craftstack.item.component;

import com.github.syr0ws.crafter.text.TextUtil;
import com.github.syr0ws.crafter.util.Validate;
import com.github.syr0ws.craftstack.item.ItemComponent;
import com.github.syr0ws.craftstack.item.ItemComponentRegistry;
import com.github.syr0ws.craftstack.item.ItemContext;
import org.bukkit.inventory.ItemStack;

/**
 * Component to change the display name of an {@link ItemStack}.
 */
public class DisplayName implements ItemComponent {

    private String displayName;

    public DisplayName(String displayName) {
        this.setDisplayName(displayName);
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        Validate.notNull(displayName, "displayName cannot be null");
        this.displayName = TextUtil.parseColors(displayName);
    }

    @Override
    public void apply(ItemContext context) {

        String displayName = context.getPlaceholderContext()
                .map(pctx -> pctx.parse(this.displayName))
                .orElse(this.displayName);

        displayName = TextUtil.parseColors(displayName);

        context.getItemMeta().setDisplayName(displayName);
    }

    @Override
    public ItemComponent copy() {
        return new DisplayName(this.displayName);
    }

    @Override
    public String getName() {
        return ItemComponentRegistry.DISPLAY_NAME.getName();
    }
}
