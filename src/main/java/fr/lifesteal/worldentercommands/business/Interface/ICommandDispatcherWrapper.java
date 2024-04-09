package fr.lifesteal.worldentercommands.business.Interface;

import java.util.Map;

/**
 * Service d'exécution de commande sur le serveur.
 */
public interface ICommandDispatcherWrapper {

    /**
     * Méthode permettant de d'exécuter une commande.
     * @param command commande à exécuter.
     * @param placeholders placeholders à appliquer à la commande.
     */
    void dispatchConsoleCommand(String command, Map<String, String> placeholders);
}
