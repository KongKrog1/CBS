package asteroids.bulletsystem;

import asteroids.common.bullet.Bullet;
import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IGamePluginService;

public class BulletPlugin implements IGamePluginService {

    private Entity bullet;

    @Override
    public void start(GameData gameData, World world) {

    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity e : world.getEntities()) {
            if (e.getClass() == Bullet.class) {
                world.removeEntity(e);
            }
        }
    }

}
