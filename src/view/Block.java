package view;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Block extends Rectangle {
    private int blockWidth;
    private int blockHeight;

    public Block(boolean solid, int x, int y, int blockWidth, int blockHeight){
        this.blockWidth = blockWidth;
        this.blockHeight = blockHeight;
        setWidth(blockWidth);
        setHeight(blockHeight);

        relocate(x*blockWidth, y*blockHeight);

        setFill(solid ? Color.SADDLEBROWN : Color.SEASHELL);
    }

    public void setColor(Color color){
        setFill(color);
    }

    public void move(int x, int y){
        relocate(x*blockWidth, y*blockHeight);
    }
}
