package view;


import javafx.scene.Group;

import java.util.stream.IntStream;


public class Maze {
    private int width;
    private int height;
    private int blockWidth;
    private int blockHeight;
    private int matrix[][];

    public Maze(){
        this.matrix = new int[width][height];
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getBlockWidth() {
        return blockWidth;
    }

    public void setBlockWidth(int blockWidth) {
        this.blockWidth = blockWidth;
    }

    public int getBlockHeight() {
        return blockHeight;
    }

    public void setBlockHeight(int blockHeight) {
        this.blockHeight = blockHeight;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void setMatrix(int[][] matrix) {
        this.matrix = matrix;
    }


    public Group drawMaze() {
        Group blockGroup = new Group();
        IntStream.range(0, this.height)
                .forEach(y -> {
                    IntStream.range(0, this.width)
                            .forEach(x -> {
                                Block block = new Block(this.matrix[y][x] == 1, x, y, this.blockWidth, this.blockHeight);
                                blockGroup.getChildren().add(block);
                            });
                });
        return blockGroup;
    }

}
