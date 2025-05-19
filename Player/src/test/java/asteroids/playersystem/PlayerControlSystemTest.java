package asteroids.playersystem;

import asteroids.common.data.GameData;
import asteroids.common.data.GameKeys;
import asteroids.common.data.World;
import asteroids.playersystem.Player;
import asteroids.playersystem.PlayerControlSystem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

class PlayerControlSystemTest {

    private PlayerControlSystem playerControlSystem;
    private GameData gameData;
    private World world;
    private Player player;

    @BeforeEach
    void setUp() {
        playerControlSystem = new PlayerControlSystem();
        gameData = mock(GameData.class);
        world = mock(World.class);
        player = new Player();

        // Set initial player position and rotation
        player.setX(50);
        player.setY(50);
        player.setRotation(0);

        // Mock the world to return the player entity
        when(world.getEntities(Player.class)).thenReturn(java.util.List.of(player));
    }

    @Test
    void testPlayerRotatesLeft() {
        // Simulate LEFT key being pressed
        GameKeys keys = new GameKeys();
        keys.setKey(GameKeys.LEFT, true);
        when(gameData.getKeys()).thenReturn(keys);

        // Process the player rotation
        playerControlSystem.process(gameData, world);

        // Verify the player's rotation has decreased
        assertEquals(-5, player.getRotation());
    }

    @Test
    void testPlayerRotatesRight() {
        // Simulate RIGHT key being pressed
        GameKeys keys = new GameKeys();
        keys.setKey(GameKeys.RIGHT, true);
        when(gameData.getKeys()).thenReturn(keys);

        // Process the player rotation
        playerControlSystem.process(gameData, world);

        // Verify the player's rotation has increased
        assertEquals(5, player.getRotation());
    }
}