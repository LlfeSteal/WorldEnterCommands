package fr.lifesteal.worldentercommands.listener;

import fr.lifesteal.worldentercommands.service.Interface.IConfigurationService;
import fr.lifesteal.worldentercommands.utils.CommandUtils;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldListener implements Listener {
    private final JavaPlugin plugin;
    private final IConfigurationService configurationService;

    public WorldListener(JavaPlugin plugin, IConfigurationService configurationService) {
        this.plugin = plugin;
        this.configurationService = configurationService;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoinWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World previousWorld = event.getFrom();
        World nextWorld = player.getWorld();

        List<String> commands = configurationService.getCommandsByWorldName(nextWorld.getName());

        if (commands.isEmpty()) return;

        Map<String, String> placeholders = new HashMap<>() {{
            put("%player", player.getName());
            put("%previousworld", previousWorld.getName());
            put("%nextworld", nextWorld.getName());
        }};

        for (String command : commands) {
            CommandUtils.dispatchConsoleCommand(this.plugin.getServer(), command, placeholders);
        }
    }
}
