package com.mycompany.covid19tracker;

import javafx.application.Application;
import javafx.stage.Stage;
import java.io.IOException;
import static javafx.application.Application.launch;

/**
 * JavaFX App
 */
public class App extends Application {
    
    @Override
    public void start(Stage stage) throws IOException {
        Switcher.setStage(stage);
        Switcher.switchPage("Main", "Covid-19 Tracker");
        stage.show();
    }
  
    public static void main(String[] args) {
        launch();
    }

}