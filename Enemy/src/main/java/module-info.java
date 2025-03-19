import asteroids.common.bullet.BulletSPI;
import asteroids.enemysystem.EnemyControlSystem;
import asteroids.enemysystem.EnemyPlugin;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;


module Enemy {
    requires Common;
    requires CommonBullet;   
    uses BulletSPI;
    provides IGamePluginService with EnemyPlugin;
    provides IEntityProcessingService with EnemyControlSystem;
    
}
