package model;


import javafx.scene.paint.Color;

public class Entity {
    private String name;
    private Position position;
    private Color color;

    public Entity(String name, int x, int y, Color color) {
        this.name = name;
        position = new Position(x, y);
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void moveUp(){
        this.position.setY(this.position.getY() - 1);
    }

    public void moveDown(){
        this.position.setY(this.position.getY() + 1);
    }

    public void moveLeft(){
        this.position.setX(this.position.getX() - 1);
    }

    public void moveRight(){
        this.position.setX(this.position.getX() + 1);
    }
}