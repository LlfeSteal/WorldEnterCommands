package fr.lifesteal.worldentercommands;

import fr.lifesteal.pluginframework.api.config.ConfigService;
import fr.lifesteal.pluginframework.core.command.PluginCommand;
import fr.lifesteal.pluginframework.core.plugin.PluginBase;
import fr.lifesteal.worldentercommands.business.Interface.IWorldCommandActionService;
import fr.lifesteal.worldentercommands.business.WorldCommandActionService;
import fr.lifesteal.worldentercommands.business.WorldWorldConfigurationService;
import fr.lifesteal.worldentercommands.business.wrapper.CommandDispatcherWrapper;
import fr.lifesteal.worldentercommands.listener.WorldListener;
import org.bukkit.event.Listener;

import java.util.ArrayList;
import java.util.List;

public class WorldEnterCommands extends PluginBase {

    private WorldWorldConfigurationService worldConfigurationService;
    private IWorldCommandActionService worldCommandActionService;

    @Override
    public void init() {
        var worldConfigRepository = getConfigRepositoryFactory().getNewYamlRepository("", "config.yml");
        this.worldConfigurationService = new WorldWorldConfigurationService(getLogger(), worldConfigRepository);

        var commandDispatcher = new CommandDispatcherWrapper(this);
        this.worldCommandActionService = new WorldCommandActionService(this.worldConfigurationService, commandDispatcher);
    }

    @Override
    protected List<PluginCommand> registerCommands() {
        return new ArrayList<>();
    }

    @Override
    protected List<ConfigService> registerConfigurationsServices() {
        return new ArrayList<>(){{
            add(worldConfigurationService);
        }};
    }

    @Override
    protected List<Listener> registerListeners() {
        return new ArrayList<>(){{
            add(new WorldListener(worldCommandActionService));
        }};
    }
}