package test;

import controller.Controller;
import model.Position;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ControllerTest {
    Controller ctrl = new Controller("T:\\Workspace\\Anul_2\\Programare\\PacMan\\src\\model\\maze.txt");

    @Test
    /**
     * Tests the method that generates a specific number of ghosts
     */
    void generateGhosts() {
        ctrl.generateGhosts(6);
        assertEquals(6, ctrl.getGhosts().size());
        assertEquals("ghost1", ctrl.getGhosts().get(0).getName());
        assertEquals(1, ctrl.getGhosts().get(3).getPosition().getX());
        assertEquals(1, ctrl.getGhosts().get(3).getPosition().getY());
    }

    @Test
    /**
     * Tests the method that notifies when the game should end
     */
    void endGame() {
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.getPacman().setPosition(new Position(1,1));
        ctrl.generateGhosts(1);
        assertTrue(ctrl.endGame());
        ctrl.getPacman().setPosition(new Position(8, 8));
    }

    @Test
    /**
     * Tests the method that moves up the pacman
     */
    void moveUp() {
        ctrl.moveLeft();
        ctrl.moveUp();
        assertEquals(7, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveRight();
        ctrl.moveUp();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(7, ctrl.getPacman().getPosition().getY());
        ctrl.moveUp();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(6, ctrl.getPacman().getPosition().getY());
    }

    @Test
    /**
     * Tests the method that moves down the pacman
     */
    void moveDown() {
        ctrl.moveUp();
        ctrl.moveUp();
        ctrl.moveDown();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(7, ctrl.getPacman().getPosition().getY());
        ctrl.moveDown();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveDown();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
    }

    @Test
    /**
     * Tests the method that moves left the pacman
     */
    void moveLeft() {
        ctrl.moveLeft();
        assertEquals(7, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());

        ctrl.moveLeft();
        assertEquals(6, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveLeft();
        ctrl.moveLeft();
        assertEquals(4, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveUp();
        assertEquals(4, ctrl.getPacman().getPosition().getX());
        assertEquals(7, ctrl.getPacman().getPosition().getY());
        ctrl.moveLeft();
        assertEquals(4, ctrl.getPacman().getPosition().getX());
        assertEquals(7, ctrl.getPacman().getPosition().getY());
    }

    @Test
    /**
     * Tests the method that moves right the pacman
     */
    void moveRight() {
        ctrl.moveRight();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveRight();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveLeft();
        assertEquals(7, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
        ctrl.moveRight();
        assertEquals(8, ctrl.getPacman().getPosition().getX());
        assertEquals(8, ctrl.getPacman().getPosition().getY());
    }
}