package fr.lifesteal.worldentercommands.listener;

import fr.lifesteal.worldentercommands.business.Interface.IWorldCommandActionService;
import fr.lifesteal.worldentercommands.business.Interface.IWorldConfigurationService;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldListener implements Listener {
    private final IWorldCommandActionService worldCommandActionService;

    public WorldListener(IWorldCommandActionService worldCommandActionService) {
        this.worldCommandActionService = worldCommandActionService;
    }

    @EventHandler(priority = EventPriority.LOWEST)
    public void onPlayerJoinWorld(PlayerChangedWorldEvent event) {
        Player player = event.getPlayer();
        World previousWorld = event.getFrom();
        World nextWorld = player.getWorld();

        this.worldCommandActionService.executeWorldEnterCommands(player.getName(), previousWorld.getName(), nextWorld.getName());
    }
}
