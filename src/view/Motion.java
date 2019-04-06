package view;

import javafx.animation.AnimationTimer;

import java.util.stream.IntStream;

import static java.lang.Math.abs;


public class Motion extends AnimationTimer {

    private KeyboardListener keyboardListener;
    private Game game;
    private long lastUpdate = 0;
    private long ghostsSpeed;
    private long ghostLastUpdate = 0;

    public Motion(Game game) {
        this.keyboardListener = new KeyboardListener();
        this.game = game;
    }

    public KeyboardListener getKeyboardListener() {
        return keyboardListener;
    }

    public void setGhostspeed(long ghostspeed) {
        this.ghostsSpeed = abs(ghostspeed- 7)*100_000_000;
    }

    @Override
    public void handle(long now) {
        IntStream.range(0, game.getGhosts().size())
                .forEach(elem ->{
                     int x = game.getCtrl().getGhosts().get(elem).getPosition().getX();
                     int y = game.getCtrl().getGhosts().get(elem).getPosition().getY();
                    System.out.println(game.getCtrl().getGhosts().get(elem).getName() + ": " + x + "   " + y);
                    game.getGhosts().get(elem).move(x, y);
                });

        if(now - ghostLastUpdate >= ghostsSpeed){
            game.getCtrl().runGhosts();
            ghostLastUpdate = now;
        }

        if(now - lastUpdate >= 250000000){

            if(keyboardListener.isGoUp()){
                game.getCtrl().moveUp();}

            if(keyboardListener.isGoDown()){
                game.getCtrl().moveDown();}

            if(keyboardListener.isGoLeft()){
                game.getCtrl().moveLeft();}

            if(keyboardListener.isGoRight()){
                game.getCtrl().moveRight();}

            game.moveCharacter();
            lastUpdate = now;
        }

        if(game.endGame()){
            this.stop();
            System.out.println("STOP");
        }
    }
}
