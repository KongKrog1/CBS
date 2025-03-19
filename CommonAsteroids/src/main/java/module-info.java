import asteroids.common.asteroids.IAsteroidSplitter;

module CommonAsteroids {
    requires Common;
    uses IAsteroidSplitter;
    exports asteroids.common.asteroids;
}