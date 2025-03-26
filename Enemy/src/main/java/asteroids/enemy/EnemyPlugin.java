package asteroids.enemy;

import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IGamePluginService;

public class EnemyPlugin implements IGamePluginService {

    private Entity enemy;

    public EnemyPlugin() {
    }

    @Override
    public void start(GameData gameData, World world) {
        System.out.println("Starting Enemy Plugin");

        // Add entities to the world
        enemy = createEnemyShip(gameData);
        world.addEntity(enemy);
    }

    private Enemy createEnemyShip(GameData gameData) {
        System.out.println("Creating enemy ship...");
        Enemy enemyShip = new Enemy(); // Directly use Enemy type
        enemyShip.setPolygonCoordinates(-5, -5, 10, 0, -5, 5);
        enemyShip.setX(gameData.getDisplayHeight() / 3);
        enemyShip.setY(gameData.getDisplayWidth() / 3);
        enemyShip.setRadius(8);
        return enemyShip; // Return directly without casting
    }

    @Override
    public void stop(GameData gameData, World world) {
        // Remove entities
        if (enemy != null) {
            world.removeEntity(enemy);
        }
    }
}
