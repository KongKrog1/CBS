
import asteroids.common.bullet.BulletSPI;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;
import asteroids.playersystem.PlayerControlSystem;
import asteroids.playersystem.PlayerPlugin;

module Player {
    requires Common;
    requires CommonBullet;   
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with PlayerControlSystem;
    
}
