package test;

import model.Map;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MapTest {

    Map map = new Map("T:\\Workspace\\Anul_2\\Programare\\PacMan\\src\\model\\maze.txt");


    @Test
    /**
     * Tests if the reading process works fine
     */
    void getMaze() {
        int[][]maze = map.getMaze();
        assertEquals(1, maze[0][0]);
        assertEquals(0, maze[2][1]);
        assertEquals(10,maze.length);
    }
}