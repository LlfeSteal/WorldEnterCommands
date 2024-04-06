package fr.lifesteal.worldentercommands.utils;

import org.bukkit.Server;

import java.util.Map;

public final class CommandUtils {

    public static void dispatchConsoleCommand(Server server, String command, Map<String, String> placeholders) {
        String parsedCommand = CommandUtils.ReplacePlaceholders(command, placeholders);
        server.dispatchCommand(server.getConsoleSender(), parsedCommand);
    }

    public static String  ReplacePlaceholders(String input, Map<String, String> placeholders) {
        for (String key : placeholders.keySet()) {
            String value = placeholders.get(key);
            input = input.replaceAll(key, value);
        }

        return input;
    }
}
