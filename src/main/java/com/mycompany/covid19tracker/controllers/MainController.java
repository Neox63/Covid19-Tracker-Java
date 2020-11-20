package com.mycompany.covid19tracker.controllers;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mycompany.covid19tracker.Tools;
import com.mycompany.covid19tracker.daos.DataDAO;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
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
    private Label labelTotalDeaths;
    @FXML
    private Label labelNewCases;
    @FXML
    private Label labelNewDeaths;
    @FXML
    private Label labelNewRecovered;
    @FXML
    private Label labelTotalCase;
    @FXML
    private Label labelTotalRecovered;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        labelLastRefresh.setAlignment(Pos.CENTER);
        labelTotalCase.setAlignment(Pos.CENTER);
        labelTotalRecovered.setAlignment(Pos.CENTER);
        labelTotalDeaths.setAlignment(Pos.CENTER);
        labelNewCases.setAlignment(Pos.CENTER);
        labelNewRecovered.setAlignment(Pos.CENTER);
        labelNewDeaths.setAlignment(Pos.CENTER);
        
        DataDAO.getData((f) -> {
            awaitAPI(f);
        });
    }    
    
    public void awaitAPI(WorkerStateEvent t){
        String apiResponse = (String) t.getSource().getValue();     
        HashMap<String, String> retrievedData = DataDAO.fromJSONString(apiResponse);
  
        labelTotalCase.setText(Tools.insertNumberComma(retrievedData.get("totalCase")));
        labelNewCases.setText("+" + Tools.insertNumberComma(retrievedData.get("newCase")) + " en 24h");
        labelTotalDeaths.setText(Tools.insertNumberComma(retrievedData.get("totalDeaths")));
        labelNewDeaths.setText("+" + Tools.insertNumberComma(retrievedData.get("newDeaths")) + " en 24h");
        labelTotalRecovered.setText(Tools.insertNumberComma(retrievedData.get("totalRecovered")));
        labelNewRecovered.setText("+" + Tools.insertNumberComma(retrievedData.get("newRecovered")) + " en 24h");
        labelLastRefresh.setText("Dernière actualisation de l'API : " + Tools.getFormattedTime(retrievedData.get("lastUpdate")));
    }
    
    @FXML
    private void clickRefresh(ActionEvent event) {
        DataDAO.getData((f) -> {
            awaitAPI(f);
        });
    }
}
