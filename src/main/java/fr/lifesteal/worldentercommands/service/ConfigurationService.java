package fr.lifesteal.worldentercommands.service;

import fr.lifesteal.worldentercommands.service.Interface.IConfigurationService;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigurationService implements IConfigurationService {
    public static final String WORLD_SECTION_KEY = "worlds";
    private final JavaPlugin plugin;
    private final FileConfiguration fileConfiguration;
    private final Map<String, List<String>> worldCommands = new HashMap<>();

    /**
     * Initialise une instance de la class ConfigurationService
     *
     * @param plugin            Plugin propriétaire du fichier de configuration.
     * @param fileConfiguration Fichier de configuration cible.
     */
    public ConfigurationService(JavaPlugin plugin, FileConfiguration fileConfiguration) {
        this.plugin = plugin;
        this.fileConfiguration = fileConfiguration;
    }

    /**
     * {@inheritDoc}
     */
    public void initDefaultConfiguration() {
        this.fileConfiguration.addDefault(
                WORLD_SECTION_KEY,
                new HashMap<String, List<String>>() {{
                    put("WorldName", new ArrayList<>(List.of("fly %player off", "say %player entered %nextworld from %previousworld")));
                }});

        this.fileConfiguration.options().copyDefaults(true);
        this.plugin.saveConfig();
    }

    /**
     * {@inheritDoc}
     */
    public void loadConfiguration() {
        ConfigurationSection section = this.fileConfiguration.getConfigurationSection(WORLD_SECTION_KEY);

        if (section == null) return;

        for (String worldName : section.getKeys(false)) {
            var currentKey = "%s.%s".formatted(section.getCurrentPath(), worldName);
            List<String> commands = section.getStringList(currentKey);
            worldCommands.put(worldName, commands);
        }
    }

    /**
     * {@inheritDoc}
     */
    public List<String> getCommandsByWorldName(String worldName) {
        return worldCommands.getOrDefault(worldName, new ArrayList<>());
    }
}
