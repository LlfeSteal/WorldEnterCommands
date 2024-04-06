package fr.lifesteal.worldentercommands.service.Interface;

import java.util.List;

/**
 * Service de gestion de la configuration.
 */
public interface IConfigurationService {

    /**
     * Méthode permettant d'initialiser le fichier de configuration.
     */
    void initDefaultConfiguration();

    /**
     * Méthode permettant de charger la configuration en cache depuis le fichier de configuration.
     */
    void loadConfiguration();

    /**
     * Méthode permettant de récupérer les commandes configuré pour le monde donné.
     * @param worldName Nom du monde pour lequel on souhaite récupérer les commandes.
     * @return Retourne les commandes configurés pour le monde.
     */
    List<String> getCommandsByWorldName(String worldName);
}
