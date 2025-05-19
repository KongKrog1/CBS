package splitter;

import asteroids.common.asteroids.Asteroid;
import asteroids.common.data.Entity;
import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IGamePluginService;

import java.util.Random;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AsteroidPlugin implements IGamePluginService {

    private ScheduledExecutorService scheduler;

    @Override
    public void start(GameData gameData, World world) {
        // Start asteroid spawning
        startAsteroidSpawning(gameData, world);
    }

    @Override
    public void stop(GameData gameData, World world) {
        for (Entity asteroid : world.getEntities(Asteroid.class)) {
            world.removeEntity(asteroid);
        }
    }

    private void startAsteroidSpawning(GameData gameData, World world) {
        scheduler = Executors.newScheduledThreadPool(1, runnable -> {
            Thread thread = new Thread(runnable);
            thread.setDaemon(true); // Mark thread as daemon
            return thread;
        });

        scheduler.scheduleAtFixedRate(() -> {
            Entity asteroid = createAsteroid(gameData);
            synchronized (world) {
                world.addEntity(asteroid);
            }
        }, 0, 1, TimeUnit.SECONDS);
    }


    private Entity createAsteroid(GameData gameData) {
        // Create a new asteroid with random properties
        Asteroid asteroid = new Asteroid();
        Random rnd = new Random();

        // Set a random size for the asteroid
        int size = rnd.nextInt(10) + 5;
        asteroid.setPolygonCoordinates(size, -size, -size, -size, -size, size, size, size);

        // Randomly choose an edge (top/bottom or left/right)
        boolean spawnOnVerticalEdge = rnd.nextBoolean(); // true for vertical, false for horizontal

        if (spawnOnVerticalEdge) {
            // Spawn on the left or right edge
            boolean spawnOnLeftEdge = rnd.nextBoolean(); // true for left, false for right
            if (spawnOnLeftEdge) {
                asteroid.setX(0); // Left edge
                asteroid.setY(rnd.nextInt(gameData.getDisplayHeight())); // Random Y on the left edge
            } else {
                asteroid.setX(gameData.getDisplayWidth()); // Right edge
                asteroid.setY(rnd.nextInt(gameData.getDisplayHeight())); // Random Y on the right edge
            }
        } else {
            // Spawn on the top or bottom edge
            boolean spawnOnTopEdge = rnd.nextBoolean(); // true for top, false for bottom
            if (spawnOnTopEdge) {
                asteroid.setX(rnd.nextInt(gameData.getDisplayWidth())); // Random X on the top edge
                asteroid.setY(0); // Top edge
            } else {
                asteroid.setX(rnd.nextInt(gameData.getDisplayWidth())); // Random X on the bottom edge
                asteroid.setY(gameData.getDisplayHeight()); // Bottom edge
            }
        }

        // Set a random radius and rotation
        asteroid.setRadius(size);
        asteroid.setRotation(rnd.nextInt(360));  // Random rotation angle from 0 to 360

        return asteroid;
    }
}
