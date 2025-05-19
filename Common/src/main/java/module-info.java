module Common {
    exports asteroids.common.services;
    exports asteroids.common.data;
    exports asteroids.common.util;
    uses asteroids.common.services.IEntityProcessingService;
    uses asteroids.common.services.IGamePluginService;
    uses asteroids.common.services.IPostEntityProcessingService;
}