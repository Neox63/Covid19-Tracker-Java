/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid19tracker;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Neox
 */
public class Tools {
    public static String insertNumberComma (String number) {
        for (int i = number.length() - 3; i > 0; i -= 3) {
            String firstPart = number.substring(0, i);
            String secondPart = number.substring(i);
            number = firstPart + "," + secondPart;
        }

        return number;
    }

    public static String getFormattedDate (String inputDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date date = new Date();
        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println(e);
        }

        DateFormat outputFormat = new SimpleDateFormat("EEEE dd MMMM yyyy");
        String dateString = outputFormat.format(date);

        return dateString;
    }
    
    public static String getFormattedTime (String inputDate) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");

        Date date = new Date();
        try {
            date = dateFormat.parse(inputDate);
        } catch (ParseException e) {
            System.out.println(e);
        }

        DateFormat outputFormat = new SimpleDateFormat("HH:mm:ss");
        String dateString = outputFormat.format(date);

        return dateString;
    }
}