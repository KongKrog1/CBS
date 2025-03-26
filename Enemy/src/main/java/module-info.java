module Enemy {
    requires Common;
    requires CommonBullet;

    uses asteroids.common.bullet.BulletSPI;

    provides asteroids.common.services.IGamePluginService with asteroids.enemy.EnemyPlugin;
    provides asteroids.common.services.IEntityProcessingService with shared.ControlSystem;

    exports shared;  // Add this line to export the shared package
}
