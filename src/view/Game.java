package view;

import controller.Controller;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Game {
    private static final int BLOCK_SIZE = 65;
    private static final int WIDTH = 10;
    private static final int HEIGHT = 10;

    private Controller ctrl;
    private Maze maze;
    private Block character;
    private List<Block> ghosts;

    public Game(Controller ctrl, Maze maze) {
        this.ctrl = ctrl;
        this.maze = maze;
        this.maze.setWidth(WIDTH);
        this.maze.setHeight(HEIGHT);
        this.maze.setBlockWidth(BLOCK_SIZE);
        this.maze.setBlockHeight(BLOCK_SIZE);
        this.maze.setMatrix(ctrl.getMap().getMaze());
        this.character = new Block(true, ctrl.getPacman().getPosition().getX(),ctrl.getPacman().getPosition().getY(),
                BLOCK_SIZE, BLOCK_SIZE);
        character.setColor(ctrl.getPacman().getColor());
        this.ghosts = new ArrayList<>();

    }

    public Controller getCtrl() {
        return ctrl;
    }

    public Maze getMaze() {
        return maze;
    }

    public Block getCharacter() {
        return character;
    }

    public List<Block> getGhosts() {
        return ghosts;
    }

    public Parent createContent(){
        Pane root = new Pane();
        root.setPrefSize(WIDTH* BLOCK_SIZE, HEIGHT*BLOCK_SIZE);
        Group blockGroup = maze.drawMaze();
        Group characterGroup = new Group();
        root.getChildren().addAll(blockGroup, characterGroup);

        characterGroup.getChildren().add(character);

        IntStream.range(0, ctrl.getGhosts().size())
                .forEach(i -> {
                    Block ghost = new Block(true, ctrl.getGhosts().get(i).getPosition().getX(), ctrl.getGhosts().get(i).getPosition().getY(),
                            BLOCK_SIZE, BLOCK_SIZE);
                    ghost.setColor(ctrl.getGhosts().get(i).getColor());
                    this.ghosts.add(ghost);
                    characterGroup.getChildren().add(ghost);
                });
        return root;
    }

    public void generateGhosts(int numberOfGhosts){
        this.ctrl.generateGhosts(numberOfGhosts);
    }

    public void moveCharacter(){
        int x  =ctrl.getPacman().getPosition().getX();
        int y = ctrl.getPacman().getPosition().getY();
        System.out.println(ctrl.getPacman().getName() + ": " + x + "   " + y);
        character.move(x,y);
    }

    public boolean endGame(){
        return ctrl.endGame();
    }

}
