import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;
import asteroids.common.services.IPostEntityProcessingService;

module Core {
    requires Common;
    requires CommonBullet;    
    requires javafx.graphics;
    requires spring.context;
    requires spring.core;
    requires spring.beans;
    opens asteroids.main to javafx.graphics,spring.core;
    uses IGamePluginService;
    uses IEntityProcessingService;
    uses IPostEntityProcessingService;
}


