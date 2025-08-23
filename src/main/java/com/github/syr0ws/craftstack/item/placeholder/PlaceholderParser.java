package com.github.syr0ws.craftstack.item.placeholder;

import java.util.List;

/**
 * Parser interface for replacing placeholders in strings.
 */
public interface PlaceholderParser {

    /**
     * Parses placeholders in a single string.
     *
     * @param text the text to process
     * @return parsed text
     */
    String parse(String text);

    /**
     * Parses placeholders in each string of a list.
     *
     * @param list the list to process
     * @return parsed list
     */
    List<String> parseAll(List<String> list);
}
