package view;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class KeyboardListener implements EventHandler<KeyEvent> {
    private boolean goUp, goDown, goLeft, goRight;
    private Game game;

    public void setGame(Game game){
        this.game = game;
    }

    public boolean isGoUp() {
        return goUp;
    }

    public boolean isGoDown() {
        return goDown;
    }

    public boolean isGoLeft() {
        return goLeft;
    }

    public boolean isGoRight() {
        return goRight;
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()){
            case UP: goUp= true; goDown=false; goLeft=false; goRight=false; break;
            case DOWN: goUp= false; goDown=true; goLeft=false; goRight=false;break;
            case LEFT: goUp= false; goDown=false; goLeft=true; goRight=false;break;
            case RIGHT: goUp= false; goDown=false; goLeft=false; goRight=true;break;
        }
    }
}
