package fr.lifesteal.worldentercommands.business.wrapper;

import fr.lifesteal.worldentercommands.business.Interface.ICommandDispatcherWrapper;
import fr.lifesteal.worldentercommands.utils.CommandUtils;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Map;

public class CommandDispatcherWrapper implements ICommandDispatcherWrapper {

    private final JavaPlugin plugin;

    public CommandDispatcherWrapper(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public void dispatchConsoleCommand(String command, Map<String, String> placeholders) {
        CommandUtils.dispatchConsoleCommand(this.plugin.getServer(), command, placeholders);
    }
}
