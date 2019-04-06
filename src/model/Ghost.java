package model;

import javafx.scene.paint.Color;

import java.util.Random;


public class Ghost extends Entity implements Runnable{
    private Map map;
    private int time;

    public Ghost(String name, int x, int y, Color color, int sleepTime, Map map) {
        super(name, x, y, color);
        this.time = sleepTime;
        this.map = map;
    }

    public void moveUpGhost(){
        if(map.getMaze()[getPosition().getY() - 1][getPosition().getX()] != 1){
            this.moveUp();}
    }

    public void moveDownGhost(){
        if(map.getMaze()[getPosition().getY() + 1][getPosition().getX()] != 1){
            this.moveDown();}
    }

    public void moveLeftGhost(){
        if(map.getMaze()[getPosition().getY()][getPosition().getX() - 1] != 1){
            this.moveLeft();}
    }

    public void moveRightGhost(){
        if(map.getMaze()[getPosition().getY()][getPosition().getX() + 1] != 1){
            this.moveRight();}
    }

    @Override
    public void run() {
        try{
                Random random = new Random();
                int movement = random.nextInt(4);
                switch (movement) {
                    case 0:
                        this.moveUpGhost();
                        break;
                    case 1:
                        this.moveDownGhost();
                        break;
                    case 2:
                        this.moveLeftGhost();
                        break;
                    case 3:
                        this.moveRightGhost();
                        break;
                }
                Thread.sleep(time);

        }catch (Exception e){}
    }
}
