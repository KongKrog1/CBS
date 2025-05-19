package splitter;

import asteroids.common.asteroids.Asteroid;
import asteroids.common.asteroids.IAsteroidSplitter;
import asteroids.common.data.Entity;
import asteroids.common.data.World;

public class AsteroidSplitterImpl implements IAsteroidSplitter {
    @Override
    public void createSplitAsteroid(Entity e, World world) {
        if (e.getRadius() < 8) return; // No need to split if too small

        float newRadius = e.getRadius() / 2;
        double[] newPolygonCoords = scalePolygon(e.getPolygonCoordinates(), 0.5);

        Entity asteroid1 = createAsteroid(e.getX() + newRadius + 1, e.getY(), newRadius, e.getRotation() + 45, newPolygonCoords);
        Entity asteroid2 = createAsteroid(e.getX() - newRadius - 45, e.getY(), newRadius, e.getRotation() / 2, newPolygonCoords);

        world.addEntity(asteroid1);
        world.addEntity(asteroid2);
        world.removeEntity(e);
    }

    private Entity createAsteroid(double x, double y, float radius, double rotation, double[] polygonCoords) {
        Entity asteroid = new Asteroid();
        asteroid.setX(x);
        asteroid.setY(y);
        asteroid.setRadius(radius);
        asteroid.setRotation(rotation);
        asteroid.setAlive(true);
        asteroid.setPolygonCoordinates(polygonCoords);
        return asteroid;
    }

    private double[] scalePolygon(double[] originalCoords, double scale) {
        double[] scaledCoords = new double[originalCoords.length];
        for (int i = 0; i < originalCoords.length; i++) {
            scaledCoords[i] = (originalCoords[i] * scale);
        }
        return scaledCoords;
    }
}
