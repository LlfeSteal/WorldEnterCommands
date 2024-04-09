package fr.lifesteal.worldentercommands.business;

import fr.lifesteal.worldentercommands.business.Interface.ICommandDispatcherWrapper;
import fr.lifesteal.worldentercommands.business.Interface.IWorldCommandActionService;
import fr.lifesteal.worldentercommands.business.Interface.IWorldConfigurationService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WorldCommandActionService implements IWorldCommandActionService {

    private final IWorldConfigurationService configurationService;
    private final ICommandDispatcherWrapper commandDispatcher;

    public WorldCommandActionService(IWorldConfigurationService configurationService, ICommandDispatcherWrapper commandDispatcher) {
        this.configurationService = configurationService;
        this.commandDispatcher = commandDispatcher;
    }

    @Override
    public void executeWorldEnterCommands(String playerName, String previousWorldName, String nextWorldName) {
        List<String> commands = configurationService.getCommandsByWorldName(nextWorldName);

        if (commands.isEmpty()) return;

        Map<String, String> placeholders = new HashMap<>() {{
            put("%player", playerName);
            put("%previousworld", previousWorldName);
            put("%nextworld", nextWorldName);
        }};

        for (String command : commands) {
            this.commandDispatcher.dispatchConsoleCommand(command, placeholders);
        }
    }
}
