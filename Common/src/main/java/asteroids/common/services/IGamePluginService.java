package asteroids.common.services;

import asteroids.common.data.GameData;
import asteroids.common.data.World;

public interface IGamePluginService {

    void start(GameData gameData, World world);

    void stop(GameData gameData, World world);
}
