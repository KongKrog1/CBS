import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;
import asteroids.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;
    opens asteroids.main to javafx.graphics;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
}


