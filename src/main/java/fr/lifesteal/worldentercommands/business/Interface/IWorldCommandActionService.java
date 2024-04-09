package fr.lifesteal.worldentercommands.business.Interface;

/**
 * Service de traitement des world commande.
 */
public interface IWorldCommandActionService {

    /**
     * Méthode permettant de traiter l'entrée dans un nouveau monde d'un joueur.
     * @param playerName nom du joueur.
     * @param previousWorldName nom du monde précédant.
     * @param nextWorldName nom du monde suivant.
     */
    void executeWorldEnterCommands(String playerName, String previousWorldName, String nextWorldName);
}
