package fr.lifesteal.worldentercommands;

import fr.lifesteal.worldentercommands.listener.WorldListener;
import fr.lifesteal.worldentercommands.service.ConfigurationService;
import fr.lifesteal.worldentercommands.service.Interface.IConfigurationService;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class WorldEnterCommands extends JavaPlugin {

    private IConfigurationService configurationService;

    @Override
    public void onEnable() {
        this.initServices();
        this.initConfiguration();
        this.initListeners();
    }

    private void initServices() {
        this.configurationService = new ConfigurationService(this, this.getConfig());
    }

    private void initConfiguration() {
        getDataFolder().mkdir();
        this.configurationService.initDefaultConfiguration();
        this.configurationService.loadConfiguration();
    }

    private void initListeners() {
        this.registerListener(new WorldListener(this, this.configurationService));
    }

    private void registerListener(Listener listener) {
        this.getServer().getPluginManager().registerEvents(listener, this);
    }
}