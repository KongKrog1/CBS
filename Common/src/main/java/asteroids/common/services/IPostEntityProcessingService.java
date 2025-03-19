package asteroids.common.services;

import asteroids.common.data.GameData;
import asteroids.common.data.World;

public interface IPostEntityProcessingService {

    void process(GameData gameData, World world);
}
