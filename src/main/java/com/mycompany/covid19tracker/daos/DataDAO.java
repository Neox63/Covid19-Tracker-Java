/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid19tracker.daos;

import com.mycompany.covid19tracker.Tools;
import com.mycompany.covid19tracker.http.Request;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Neox
 */
public class DataDAO {
    public static void getData(EventHandler<WorkerStateEvent> f) {
        String query = "";
        
        try {
            Request gt = new Request(query);
            gt.setOnSucceeded(f);
            Thread th = new Thread(gt);
            th.start();
        } catch (Exception ex) {
            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static HashMap<String, String> fromJSONString(String jsonStr){
        HashMap<String, String> hmData = new HashMap();
        
        String totalCase;
        String newCase;
        String totalDeaths;
        String newDeaths;
        String totalRecovered;
        String newRecovered;
        String lastUpdate;
        
        try {
            JSONParser jsonP = new JSONParser();
            JSONObject jsono = (JSONObject) jsonP.parse(jsonStr);
            
            totalCase = ((JSONObject) (JSONObject) jsono.get("Global")).get("TotalConfirmed").toString();
            Tools.insertNumberComma(totalCase);
            hmData.put("totalCase", totalCase);
            
            newCase = ((JSONObject) (JSONObject) jsono.get("Global")).get("NewConfirmed").toString();
            Tools.insertNumberComma(newCase);
            hmData.put("newCase", newCase);
            
            totalDeaths = ((JSONObject) (JSONObject) jsono.get("Global")).get("TotalDeaths").toString();
            Tools.insertNumberComma(totalDeaths);
            hmData.put("totalDeaths", totalDeaths);
            
            newDeaths = ((JSONObject) (JSONObject) jsono.get("Global")).get("NewDeaths").toString();
            Tools.insertNumberComma(newDeaths);
            hmData.put("newDeaths", newDeaths);
            
            totalRecovered = ((JSONObject) (JSONObject) jsono.get("Global")).get("TotalRecovered").toString();
            Tools.insertNumberComma(totalRecovered);
            hmData.put("totalRecovered", totalRecovered);
            
            newRecovered = ((JSONObject) (JSONObject) jsono.get("Global")).get("NewRecovered").toString();
            Tools.insertNumberComma(newRecovered);
            hmData.put("newRecovered", newRecovered);
            
            lastUpdate = jsono.get("Date").toString();
            hmData.put("lastUpdate", lastUpdate);
            
        } catch (ParseException ex) {
            Logger.getLogger(DataDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return hmData;
    }
}
