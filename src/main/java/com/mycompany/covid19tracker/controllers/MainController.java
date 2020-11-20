package com.mycompany.covid19tracker.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author Neox
 */
public class MainController implements Initializable {

    @FXML
    private Label labelLastRefresh;
    @FXML
    private Label labeltotalCase;
    @FXML
    private Label labelTotalDeaths;
    @FXML
    private Label labelTotalRecovered;
    @FXML
    private Label labelToday;
    @FXML
    private Label labelNewCases;
    @FXML
    private Label labelNewDeaths;
    @FXML
    private Label labelNewRecovered;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void clickRefresh(ActionEvent event) {
        
    }
}
