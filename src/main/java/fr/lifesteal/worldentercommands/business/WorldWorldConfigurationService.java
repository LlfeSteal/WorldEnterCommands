package fr.lifesteal.worldentercommands.business;

import fr.lifesteal.pluginframework.api.config.ConfigRepository;
import fr.lifesteal.pluginframework.core.config.ConfigParam;
import fr.lifesteal.pluginframework.core.config.ConfigServiceBase;
import fr.lifesteal.worldentercommands.business.Interface.IWorldConfigurationService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class WorldWorldConfigurationService extends ConfigServiceBase implements IWorldConfigurationService {

    @ConfigParam(paramKey = "worlds")
    private Map<String, List<String>> worldCommands = new HashMap<>() {{
        put("world", new ArrayList<>(List.of("fly %player off", "say %player entered %nextworld from %previousworld")));
    }};

    public WorldWorldConfigurationService(Logger logger, ConfigRepository configRepository) {
        super(logger, configRepository);
    }

    @Override
    public List<String> getCommandsByWorldName(String worldName) {
        return worldCommands.getOrDefault(worldName, new ArrayList<>());
    }
}
