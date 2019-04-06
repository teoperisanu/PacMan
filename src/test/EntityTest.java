package test;

import javafx.scene.paint.Color;
import model.Entity;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EntityTest {


    @Test
    /**
     * Tests the moveUp method of an entity
     */
    void moveUp() {
        Entity entity = new Entity("test", 1,2, Color.YELLOW);
        assertEquals(1, entity.getPosition().getX());
        assertEquals(2, entity.getPosition().getY());
        entity.moveUp();
        assertEquals(1, entity.getPosition().getX());
        Assertions.assertEquals(1, entity.getPosition().getY());
    }

    @Test
    /**
     * Tests the moveDown method of an entity
     */
    void moveDown() {
        Entity entity = new Entity("test", 1,2, Color.YELLOW);
        Assert.assertEquals(1, entity.getPosition().getX());
        Assert.assertEquals(2, entity.getPosition().getY());
        entity.moveDown();
        Assert.assertEquals(1, entity.getPosition().getX());
        Assert.assertEquals(3, entity.getPosition().getY());
    }

    @Test
    /**
     * Tests the moveLeft method of an entity
     */
    void moveLeft() {
        Entity entity = new Entity("test", 1,2, Color.YELLOW);
        Assert.assertEquals(1, entity.getPosition().getX());
        Assert.assertEquals(2, entity.getPosition().getY());
        entity.moveLeft();
        Assert.assertEquals(0, entity.getPosition().getX());
        Assert.assertEquals(2, entity.getPosition().getY());
    }

    @Test
    /**
     * Tests the moveRight method of an entity
     */
    void moveRight() {
        Entity entity = new Entity("test", 1,2, Color.YELLOW);
        Assert.assertEquals(1, entity.getPosition().getX());
        Assert.assertEquals(2, entity.getPosition().getY());
        entity.moveRight();
        Assert.assertEquals(2, entity.getPosition().getX());
        Assert.assertEquals(2, entity.getPosition().getY());
    }
}
