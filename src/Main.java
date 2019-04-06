import javafx.application.Application;

import javafx.scene.Scene;

import javafx.stage.Stage;

import view.*;
import controller.*;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Controller ctrl = new Controller("src/model/maze.txt");
        Maze maze = new Maze();

        Game game = new Game(ctrl, maze);




        Settings s = new Settings();
        Scene settings = new Scene(s.createSettings(), 500, 250);
        s.getStartButton().setOnAction(e -> {
            game.generateGhosts((int)s.getNoGhostsSlider().getValue());
            Scene scene = new Scene(game.createContent());
            Motion timer = new Motion(game);
            timer.setGhostspeed((long)s.getGhostSpeedSlider().getValue());
            timer.start();
            scene.setOnKeyPressed((timer).getKeyboardListener());
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        });



        primaryStage.setTitle("PacMan");
        primaryStage.setScene(settings);
        primaryStage.show();


    }

    public static void main(final String[] arguments) {
        Application.launch(arguments);
    }

}
