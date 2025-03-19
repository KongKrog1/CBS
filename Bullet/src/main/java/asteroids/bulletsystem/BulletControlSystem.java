package asteroids.bulletsystem;

import asteroids.common.bullet.Bullet;
import asteroids.common.bullet.BulletSPI;
import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IEntityProcessingService;

public class BulletControlSystem implements IEntityProcessingService, BulletSPI {

    // Add a counter to track the number of bullets created
    private static int bulletCounter = 0;

    @Override
    public void process(GameData gameData, World world) {

        for (Entity bullet : world.getEntities(Bullet.class)) {
            double changeX = Math.cos(Math.toRadians(bullet.getRotation()));
            double changeY = Math.sin(Math.toRadians(bullet.getRotation()));
            bullet.setX(bullet.getX() + changeX * 3);
            bullet.setY(bullet.getY() + changeY * 3);

            double screenWidth = gameData.getDisplayWidth();
            double screenHeight = gameData.getDisplayHeight();

            if(bullet.getX() < 0 || bullet.getX() > screenWidth
                    || bullet.getY() < 0 ||bullet.getY() > screenHeight) {
                world.removeEntity(bullet);
            }
        }
    }

    @Override
    public Entity createBullet(Entity shooter, GameData gameData) {
        // Increment the counter every time a bullet is created
        bulletCounter++;

        // Only create the bullet if the counter is divisible by 5
        if (bulletCounter % 5 == 0) {
            Entity bullet = new Bullet();
            bullet.setPolygonCoordinates(2, -2, 2, 2, -2, 2, -2, -2);
            double changeX = Math.cos(Math.toRadians(shooter.getRotation()));
            double changeY = Math.sin(Math.toRadians(shooter.getRotation()));
            bullet.setX(shooter.getX() + changeX * 10);
            bullet.setY(shooter.getY() + changeY * 10);
            bullet.setRotation(shooter.getRotation());
            bullet.setRadius(2);

            // Return the created bullet
            return bullet;
        } else {
            Entity uselessBullet = new Bullet();
            uselessBullet.setPolygonCoordinates(1, -1, 1, 1, -1, 1, -1, -1);
            uselessBullet.setX(0);
            uselessBullet.setY(0);
            uselessBullet.setRotation(-45);
            uselessBullet.setRadius(0);

            // Return the created bullet
            return uselessBullet;
        }
    }
}
