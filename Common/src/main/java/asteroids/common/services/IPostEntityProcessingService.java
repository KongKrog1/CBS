package asteroids.common.services;

import asteroids.common.data.GameData;
import asteroids.common.data.World;

/**
 * Interface for post-entity processing services.
 * These services handle additional logic after the main entity processing is complete.
 */
public interface IPostEntityProcessingService {

    /**
     * Processes entities after the main entity processing is complete.
     *
     * Preconditions:
     * - `gameData` and `world` must not be null.
     * - The `world` contains entities to be processed.
     *
     * Postconditions:
     * - Additional logic is applied to entities in the `world`.
     *
     * @param gameData The game data containing configuration and state information.
     * @param world The game world where entities are managed.
     */
    void process(GameData gameData, World world);
}