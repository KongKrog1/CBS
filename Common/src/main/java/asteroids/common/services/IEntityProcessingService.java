package asteroids.common.services;

import asteroids.common.data.GameData;
import asteroids.common.data.World;

/**
 * Interface for entity processing services.
 * These services handle the logic for updating entities during the game loop.
 */
public interface IEntityProcessingService {

    /**
     * Processes and updates entities in the game world.
     *
     * Preconditions:
     * - `gameData` and `world` must not be null.
     * - The `world` contains entities to be processed.
     *
     * Postconditions:
     * - Entities in the `world` are updated based on game logic.
     *
     * @param gameData The game data containing configuration and state information.
     * @param world The game world where entities are managed.
     */
    void process(GameData gameData, World world);
}