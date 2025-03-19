package asteroids.common.asteroids;

import asteroids.common.data.Entity;

public class Asteroid extends Entity {

    private int splitLevel = 0; // Track how many times it has split

    public int getSplitLevel() {
        return splitLevel;
    }

    public void setSplitLevel(int splitLevel) {
        this.splitLevel = splitLevel;
    }
}
