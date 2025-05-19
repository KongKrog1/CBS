package splitter;

import asteroids.common.data.GameData;
import asteroids.common.data.World;
import asteroids.common.services.IEntityProcessingService;

public class splitPackage implements IEntityProcessingService {
    @Override
    public void process(GameData gameData, World world) {
        System.out.println("This is a split package in Asteroid");
    }
}
