package asteroids.common.services;

import asteroids.common.data.GameData;
import asteroids.common.data.World;

/**
 * Interface for game plugin services.
 * Plugins are responsible for initializing and cleaning up game entities and resources.
 */
public interface IGamePluginService {

    /**
     * Starts the plugin and initializes any required entities or resources.
     *
     * Preconditions:
     * - `gameData` and `world` must not be null.
     *
     * Postconditions:
     * - Entities or resources required by the plugin are added to the `world`.
     *
     * @param gameData The game data containing configuration and state information.
     * @param world The game world where entities are managed.
     */
    void start(GameData gameData, World world);

    /**
     * Stops the plugin and cleans up any entities or resources it created.
     *
     * Preconditions:
     * - `gameData` and `world` must not be null.
     *
     * Postconditions:
     * - Entities or resources created by the plugin are removed from the `world`.
     *
     * @param gameData The game data containing configuration and state information.
     * @param world The game world where entities are managed.
     */
    void stop(GameData gameData, World world);
}