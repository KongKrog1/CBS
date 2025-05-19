
import asteroids.common.bullet.BulletSPI;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;
import splitter.PlayerControlSystem;
import splitter.PlayerPlugin;

module Player {
    requires Common;
    requires CommonBullet;   
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem, splitter.splitPackage;
    
}
