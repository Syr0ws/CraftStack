package com.github.syr0ws.craftstack.item.placeholder;

import com.github.syr0ws.crafter.util.Validate;
import me.clip.placeholderapi.PlaceholderAPI;
import org.bukkit.entity.Player;

import java.util.List;

/**
 * {@link PlaceholderParser} that uses PlaceholderAPI for placeholder replacement.
 */
public class PlaceholderApiParser implements PlaceholderParser {

    private final Player player;

    /**
     * Creates a parser for the given player.
     *
     * @param player the player context
     */
    public PlaceholderApiParser(Player player) {
        Validate.notNull(player, "player cannot be null");
        this.player = player;
    }

    @Override
    public String parse(String text) {
        Validate.notNull(text, "text cannot be null");
        return PlaceholderAPI.setPlaceholders(this.player, text);
    }

    @Override
    public List<String> parseAll(List<String> list) {
        Validate.notNull(list, "list cannot be null");
        return PlaceholderAPI.setPlaceholders(this.player, list);
    }
}
