import asteroids.bulletsystem.BulletControlSystem;
import asteroids.bulletsystem.BulletPlugin;
import asteroids.common.bullet.BulletSPI;
import asteroids.common.services.IEntityProcessingService;
import asteroids.common.services.IGamePluginService;

module Bullet {
    requires Common;
    requires CommonBullet;
    provides IGamePluginService with BulletPlugin;
    provides BulletSPI with BulletControlSystem;
    provides IEntityProcessingService with BulletControlSystem;
}