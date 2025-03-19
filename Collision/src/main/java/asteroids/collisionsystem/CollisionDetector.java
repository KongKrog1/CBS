package asteroids.collisionsystem;

import asteroids.common.asteroids.IAsteroidSplitter;
import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IPostEntityProcessingService;

import java.util.ServiceLoader;

public class CollisionDetector implements IPostEntityProcessingService {


    private static IAsteroidSplitter asteroidSplitter;

    public CollisionDetector() {
        if (asteroidSplitter == null) {
            ServiceLoader<IAsteroidSplitter> loader = ServiceLoader.load(IAsteroidSplitter.class);
            for (IAsteroidSplitter splitter : loader) {
                asteroidSplitter = splitter;
                break;
            }
        }
    }


    @Override
    public void process(GameData gameData, World world) {
        for (Entity entity1 : world.getEntities()) {
            for (Entity entity2 : world.getEntities()) {
                if (entity1.getClass().equals(entity2.getClass())) {
                    continue;
                }

                if (this.collides(entity1, entity2)) {
                    entity1.setAlive(false);
                    entity2.setAlive(false);
                }
            }
        }
    }

    public Boolean collides(Entity entity1, Entity entity2) {
        double dx = entity1.getX() - entity2.getX();
        double dy = entity1.getY() - entity2.getY();
        float distance = (float) Math.sqrt(dx * dx + dy * dy);
        return distance < (entity1.getRadius() + entity2.getRadius());
    }
}
