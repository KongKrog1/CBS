
import asteroids.common.bullet.BulletSPI;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;
import shared.ControlSystem;
import asteroids.player.PlayerPlugin;

module Player {
    requires Common;
    requires CommonBullet;   
    uses BulletSPI;
    provides IGamePluginService with PlayerPlugin;
    provides IEntityProcessingService with ControlSystem;

}
