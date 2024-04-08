package fr.lifesteal.worldentercommands.business.Interface;

import java.util.List;

/**
 * Service de gestion de la configuration des modes.
 */
public interface IWorldConfigurationService {
    /**
     * Méthode permettant de récupérer les commandes configuré pour le monde donné.
     * @param worldName Nom du monde pour lequel on souhaite récupérer les commandes.
     * @return Les commandes configurés pour le monde ou une liste vide si aucune configuration n'a été trouvée.
     */
    List<String> getCommandsByWorldName(String worldName);
}
