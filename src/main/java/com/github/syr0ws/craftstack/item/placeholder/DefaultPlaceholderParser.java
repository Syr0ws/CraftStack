package com.github.syr0ws.craftstack.item.placeholder;

import com.github.syr0ws.crafter.message.placeholder.Placeholder;
import com.github.syr0ws.crafter.util.Validate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Simple {@link PlaceholderParser} that replaces {@link Placeholder} keys with mapped values.
 */
public class DefaultPlaceholderParser implements PlaceholderParser {

    private final Map<Placeholder, String> placeholders = new HashMap<>();

    /**
     * Creates a parser with the given mappings.
     *
     * @param placeholders the placeholder mappings
     */
    public DefaultPlaceholderParser(Map<Placeholder, String> placeholders) {
        Validate.notNull(placeholders, "placeholders cannot be null");
        this.placeholders.putAll(placeholders);
    }

    @Override
    public String parse(String text) {
        Validate.notNull(text, "text cannot be null");

        String parsed = text;
        for(Map.Entry<Placeholder, String> entry : this.placeholders.entrySet()) {
            parsed = parsed.replace(entry.getKey().getName(), entry.getValue());
        }

        return parsed;
    }

    @Override
    public List<String> parseAll(List<String> list) {
        Validate.notNull(list, "list cannot be null");
        return list.stream().map(this::parse).collect(Collectors.toList());
    }
}
