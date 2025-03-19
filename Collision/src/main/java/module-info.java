import asteroids.collisionsystem.CollisionDetector;
import asteroids.common.asteroids.IAsteroidSplitter;
import asteroids.common.services.IPostEntityProcessingService;

module Collision {
    uses IAsteroidSplitter;
    requires Common;
    requires CommonAsteroids;
    requires Player;
    provides IPostEntityProcessingService with CollisionDetector;
}