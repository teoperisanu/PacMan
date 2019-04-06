package controller;


import javafx.scene.paint.Color;
import model.*;
import model.Map;

import java.util.*;
import java.util.stream.IntStream;

public class Controller {
    private Entity pacman;
    private List<Ghost> ghosts;
    private Map map;

    /**
     * Initializes a controller object
     * @param filename the name of the file, where the maze is stored
     */
    public Controller(String filename) {
        this.map = new Map(filename);
        Position position = generateValidPositionDown();
        this.pacman = new Entity("pacman", position.getX(), position.getY(),Color.YELLOW);
        this.ghosts = new ArrayList<>();
    }

    /**
     * @return the pacman entity
     */
    public Entity getPacman() {
        return pacman;
    }

    /**
     * Sets the value of the pacman
     * @param pacman an entity
     */
    public void setPacman(Entity pacman) {
        this.pacman = pacman;
    }

    /**
     * @return the list that contains all the ghosts
     */
    public List<Ghost> getGhosts() {
        return ghosts;
    }

    /**
     * Sets the list of ghosts
     * @param ghosts a new list with ghosts
     */
    public void setGhosts(List<Ghost> ghosts) {
        this.ghosts = ghosts;
    }

    /**
     * @return a map object, that contains the structure of the maze
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the value of the map
     * @param map new map object
     */
    public void setMap(Map map) {
        this.map = map;
    }

    /**
     * Generates a specific number of ghosts
     * @param numberOfGhosts the number of the ghosts in the game
     */
    public void generateGhosts(int numberOfGhosts){
        IntStream.range(1, numberOfGhosts + 1)
                .forEach(elem -> {
                    ghosts.add(new Ghost("ghost" + elem, generateValidPositionUp().getX(), generateValidPositionUp().getY(), Color.SALMON, 1000, map));
                });
    }

    /**
     * Generates a position in the top side of the matrix where are no blocks
     * @return the valid position
     */
    private Position generateValidPositionUp(){
        int index = IntStream.range(0, map.getWIDTH())
                .filter(i -> map.getMaze()[i][i] == 0)
                .findFirst()
                .orElse(-1);
        return new Position(index,index);
    }

    /**
     * Generates a position in the down side of the map where are no blocks
     * @return the valid position
     */
    private Position generateValidPositionDown(){
        int start = 0;
        int end = map.getWIDTH();
        int index = IntStream.range(start, end)
                .map(i -> start + (end - 1 - i))
                .filter(i -> map.getMaze()[i][i] == 0)
                .findFirst()
                .orElse(-1);
        return new Position(index,index);
    }


    /**
     * For every ghost creates a thread and start it
     */
    public void runGhosts(){
        this.ghosts.stream().forEach(g -> {
            Thread thread = new Thread(g);
            thread.start();
        });

    }

    /**
     * Notifies when the game should stop - pacman met a ghost
     * @return
     */
    public boolean endGame(){
        final boolean[] end = {false};
        this.ghosts.stream().forEach(g -> {
            if(g.getPosition().getX() == pacman.getPosition().getX() && g.getPosition().getY() == pacman.getPosition().getY()){
                end[0] = true;
            }
        });
        return end[0];
    }

    /**
     * Moves up the pacman if there is no block
     */
    public void moveUp(){
        if(map.getMaze()[pacman.getPosition().getY() - 1][pacman.getPosition().getX()] != 1){
            this.pacman.moveUp();}
    }

    /**
     * Moves down the pacman if there is no block
     */
    public void moveDown(){
        if(map.getMaze()[pacman.getPosition().getY() + 1][pacman.getPosition().getX()] != 1){
            this.pacman.moveDown();}
    }

    /**
     * Moves left the pacman if there is no block
     */
    public void moveLeft(){
        if(map.getMaze()[pacman.getPosition().getY()][pacman.getPosition().getX() - 1] != 1){
            this.pacman.moveLeft();}
    }

    /**
     * Moves right the pacman if there is no block
     */
    public void moveRight(){
        if(map.getMaze()[pacman.getPosition().getY()][pacman.getPosition().getX() + 1] != 1){
            this.pacman.moveRight();}
    }


}
