/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid19tracker;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Switcher {

    private static Stage stage;

    public static void setStage(Stage stage) {
        Switcher.stage = stage;
    }

    public static Stage getStage() {
        return stage;
    }

    public static void switchPage(String nomPage, String title) {
        try {
            switcher(nomPage, title);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    private static FXMLLoader switcher(String nomPage, String title) throws IOException {
        nomPage = "views/" + nomPage + ".fxml";
        FXMLLoader fxmlLoader = new FXMLLoader(Switcher.class.getResource(nomPage));
        
        Parent root = (Parent) fxmlLoader.load();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle(title);
        return fxmlLoader;
    }
}
