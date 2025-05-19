import splitter.AsteroidPlugin;
import splitter.AsteroidProcessor;
import splitter.AsteroidSplitterImpl;
import asteroids.common.asteroids.IAsteroidSplitter;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;

module Asteroid {
    requires Common;
    requires CommonAsteroids;
    provides IAsteroidSplitter with AsteroidSplitterImpl;
    provides IGamePluginService with AsteroidPlugin;
    provides IEntityProcessingService with AsteroidProcessor, splitter.splitPackage;
}