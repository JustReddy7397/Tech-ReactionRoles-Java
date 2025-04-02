package ga.justreddy.wiki.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JustReddy
 */
public class Color {

    private static final Map<Character, String> ANSI_COLORS = new HashMap<>();

    static {
        ANSI_COLORS.put('0', "\u001B[30m"); // Black
        ANSI_COLORS.put('1', "\u001B[34m"); // Dark Blue
        ANSI_COLORS.put('2', "\u001B[32m"); // Dark Green
        ANSI_COLORS.put('3', "\u001B[36m"); // Dark Aqua
        ANSI_COLORS.put('4', "\u001B[31m"); // Dark Red
        ANSI_COLORS.put('5', "\u001B[35m"); // Dark Purple
        ANSI_COLORS.put('6', "\u001B[33m"); // Gold
        ANSI_COLORS.put('7', "\u001B[37m"); // Gray
        ANSI_COLORS.put('8', "\u001B[90m"); // Dark Gray
        ANSI_COLORS.put('9', "\u001B[94m"); // Blue
        ANSI_COLORS.put('a', "\u001B[92m"); // Green
        ANSI_COLORS.put('b', "\u001B[96m"); // Aqua
        ANSI_COLORS.put('c', "\u001B[91m"); // Red
        ANSI_COLORS.put('d', "\u001B[95m"); // Light Purple
        ANSI_COLORS.put('e', "\u001B[93m"); // Yellow
        ANSI_COLORS.put('f', "\u001B[97m"); // White
        ANSI_COLORS.put('l', "\u001B[1m");  // Bold
        ANSI_COLORS.put('n', "\u001B[4m");  // Underline
        ANSI_COLORS.put('r', "\u001B[0m");  // Reset
    }

    public static String translate(String message) {
        StringBuilder result = new StringBuilder();
        char[] chars = message.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '&' && i + 1 < chars.length) {
                char code = chars[i + 1];
                String ansi = ANSI_COLORS.get(code);
                if (ansi != null) {
                    result.append(ansi);
                    i++;
                    continue;
                }
            }
            result.append(chars[i]);
        }
        result.append("\u001B[0m");
        return result.toString();
    }

}
