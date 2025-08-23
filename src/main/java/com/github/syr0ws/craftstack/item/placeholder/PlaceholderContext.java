package com.github.syr0ws.craftstack.item.placeholder;

import com.github.syr0ws.crafter.message.placeholder.Placeholder;
import com.github.syr0ws.crafter.util.Validate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Context holding a list of {@link PlaceholderParser} used to parse texts.
 */
public class PlaceholderContext {

    private final List<PlaceholderParser> parsers;

    private PlaceholderContext(List<PlaceholderParser> parsers) {
        this.parsers = Collections.unmodifiableList(parsers);
    }

    /**
     * Replace all placeholders in a string using all configured parsers.
     *
     * @param text the text to parse
     * @return parsed text
     */
    public String parse(String text) {
        Validate.notNull(text, "text cannot be null");
        for (PlaceholderParser parser : this.parsers) {
            text = parser.parse(text);
        }
        return text;
    }

    /**
     * Replace all placeholders in a list of strings using all configured parsers
     *
     * @param list the list to parse
     * @return parsed list
     */
    public List<String> parseAll(List<String> list) {
        Validate.notNull(list, "list cannot be null");
        return list.stream().map(this::parse).collect(Collectors.toList());
    }

    /**
     * Builder for creating {@link PlaceholderContext} instances.
     */
    public static class Builder {

        private final List<PlaceholderParser> parsers = new ArrayList<>();

        /**
         * Adds a {@link DefaultPlaceholderParser} with the given mappings.
         *
         * @param placeholders the placeholder mappings
         * @return this builder
         */
        public Builder withDefaultParser(Map<Placeholder, String> placeholders) {
            Validate.notNull(placeholders, "placeholders cannot be null");
            this.parsers.add(new DefaultPlaceholderParser(placeholders));
            return this;
        }

        /**
         * Adds a custom {@link PlaceholderParser}.
         *
         * @param parser the parser to add
         * @return this builder
         */
        public Builder withParser(PlaceholderParser parser) {
            Validate.notNull(parser, "parser cannot be null");
            this.parsers.add(parser);
            return this;
        }

        /**
         * Builds the context with the configured parsers.
         *
         * @return new {@link PlaceholderContext}
         */
        public PlaceholderContext build() {
            return new PlaceholderContext(this.parsers);
        }
    }
}
