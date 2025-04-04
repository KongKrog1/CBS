package asteroids.playersystem;

import asteroids.common.bullet.BulletSPI;
import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.GameKeys;
import asteroids.common.data.World;
import asteroids.common.services.IEntityProcessingService;

import java.util.Collection;
import java.util.ServiceLoader;

import static java.util.stream.Collectors.toList;


public class PlayerControlSystem implements IEntityProcessingService {

    @Override
    public void process(GameData gameData, World world) {

        for (Entity player : world.getEntities(Player.class)) {
            if (gameData.getKeys().isDown(GameKeys.LEFT)) {
                player.setRotation(player.getRotation() - 5);
            }
            if (gameData.getKeys().isDown(GameKeys.RIGHT)) {
                player.setRotation(player.getRotation() + 5);
            }
            if (gameData.getKeys().isDown(GameKeys.UP)) {
                double changeX = Math.cos(Math.toRadians(player.getRotation()));
                double changeY = Math.sin(Math.toRadians(player.getRotation()));
                player.setX(player.getX() + changeX);
                player.setY(player.getY() + changeY);
            }
            if(gameData.getKeys().isDown(GameKeys.SPACE)) {
                getBulletSPIs().stream().findFirst().ifPresent(
                        spi -> {if (spi.createBullet(player, gameData) != null) {world.addEntity(spi.createBullet(player, gameData));}}
                );
            }

            if (player.getX() < 0) {
                player.setX(gameData.getDisplayWidth());
            }
            if (player.getX() > gameData.getDisplayWidth()) {
                player.setX(0);
            }
            if (player.getY() < 0) {
                player.setY(gameData.getDisplayHeight());
            }
            if (player.getY() > gameData.getDisplayHeight()) {
                player.setY(0);
            }
        }
    }

    private Collection<? extends BulletSPI> getBulletSPIs() {
        return ServiceLoader.load(BulletSPI.class).stream().map(ServiceLoader.Provider::get).collect(toList());
    }
}
