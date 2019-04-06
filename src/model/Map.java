package model;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Map {
    private final int WIDTH = 10;
    private final int HEIGHT = 10;
    private int[][] maze;

    public Map(String filename) {
        this.maze = new int[WIDTH][HEIGHT];
        readMaze(filename);
    }

    public int getWIDTH() {
        return WIDTH;
    }

    public int getHEIGHT() {
        return HEIGHT;
    }

    public int[][] getMaze() {
        return maze;
    }

    public void setMaze(int[][] maze) {
        this.maze = maze;
    }

    public void setValue(int x, int y, int value){
        this.maze[x][y] = value;
    }

    private void readMaze(String filename) {
        try {
            Point obj = new Point();
            obj.i = 0;
            obj.j = 0;

            Stream<String> line = Files.lines(Paths.get(filename))
                    .map(x -> x.split(" "))
                    .flatMap(Arrays::stream);
            List<String> list = line.collect(Collectors.toList());


            list.stream().forEach(elem -> {
                maze[obj.i][obj.j] = Integer.parseInt(elem);
                obj.j++;
                if (obj.j == 10)
                {
                    obj.j = 0;
                    obj.i++;
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    private static class Point
    {
        private int i;
        private int j;
    }
}
