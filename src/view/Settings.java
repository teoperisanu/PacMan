package view;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.VBox;


public class Settings {
    private Slider noGhostsSlider;
    private Slider ghostSpeedSlider;
    private Button startButton;

    public Slider getNoGhostsSlider() {
        return noGhostsSlider;
    }

    public Slider getGhostSpeedSlider() {
        return ghostSpeedSlider;
    }

    public Button getStartButton() {
        return startButton;
    }

    public VBox createSettings() {
        Label noGhostsLabel = new Label("Number of ghosts: ");
        noGhostsSlider = new Slider(1, 5, 3);
        noGhostsSlider.setShowTickLabels(true);
        noGhostsSlider.setShowTickMarks(true);
        noGhostsSlider.setSnapToTicks(true);
        noGhostsSlider.setMajorTickUnit(1);
        noGhostsSlider.setMinorTickCount(0);


        Label ghostSpeedLabel = new Label("Ghosts' speed: ");
        ghostSpeedSlider = new Slider(1, 6, 3.5);
        ghostSpeedSlider.setShowTickLabels(true);
        ghostSpeedSlider.setShowTickMarks(true);
        ghostSpeedSlider.setMajorTickUnit(1);
        ghostSpeedSlider.setMinorTickCount(0);

        startButton = new Button("Start!");

        VBox layout = new VBox(20);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(noGhostsLabel, noGhostsSlider, ghostSpeedLabel, ghostSpeedSlider, startButton);
        return layout;
    }



}
