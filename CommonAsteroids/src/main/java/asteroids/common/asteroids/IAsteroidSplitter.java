package asteroids.common.asteroids;

import asteroids.common.data.Entity;
import asteroids.common.data.World;

public interface IAsteroidSplitter {
    void createSplitAsteroid(Entity e, World w);
}
