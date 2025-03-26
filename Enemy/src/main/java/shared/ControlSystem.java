package shared;

import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IEntityProcessingService;
import asteroids.enemy.Enemy;

public class ControlSystem implements IEntityProcessingService {

    private static final double FORWARD_SPEED = 2.0; // Forward speed for the enemy
    @Override
    public void process(GameData gameData, World world) {
        for (Entity enemy : world.getEntities(Enemy.class)) {

            int enemyMove = (int) (Math.random()*50) + 1;
            if (enemyMove == 1 || enemyMove == 2) {
                enemy.setRotation(enemy.getRotation() - 10);
            }
            if (enemyMove == 3 || enemyMove == 4) {
                enemy.setRotation(enemy.getRotation() + 10);
            }



            // Move the enemy forward in the direction it is facing
            double changeX = Math.cos(Math.toRadians(enemy.getRotation())) * FORWARD_SPEED;
            double changeY = Math.sin(Math.toRadians(enemy.getRotation())) * FORWARD_SPEED;
            enemy.setX(enemy.getX() + changeX);
            enemy.setY(enemy.getY() + changeY);

            // Keep the enemy within screen boundaries
            if (enemy.getX() < 0) {
                enemy.setX(gameData.getDisplayWidth());
            }
            if (enemy.getX() > gameData.getDisplayWidth()) {
                enemy.setX(0);
            }
            if (enemy.getY() < 0) {
                enemy.setY(gameData.getDisplayHeight());
            }
            if (enemy.getY() > gameData.getDisplayHeight()) {
                enemy.setY(0);
            }
        }
    }
}
