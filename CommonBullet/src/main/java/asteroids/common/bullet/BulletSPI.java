package asteroids.common.bullet;

import asteroids.common.data.Entity;
import asteroids.common.data.GameData;

public interface BulletSPI {
    Entity createBullet(Entity e, GameData gameData);
}
