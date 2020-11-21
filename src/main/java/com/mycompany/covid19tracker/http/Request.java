/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.covid19tracker.http;

import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpClient.Redirect;
import java.net.http.HttpClient.Version;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.time.Duration;
import static java.time.temporal.ChronoUnit.SECONDS;
import javafx.concurrent.Task;

public class Request extends Task<String> {

    private static final String URLBASE = "https://api.covid19api.com/";
    private final String action;
    private final static String CHARSET = "UTF-8";

    public Request(String action) {
        this.action = action;
    }

    @Override
    protected String call() throws Exception {  
        HttpRequest request = HttpRequest.newBuilder()
        .uri(new URI(URLBASE + URLEncoder.encode(action, CHARSET)))
        .timeout(Duration.ofSeconds(5))
        .GET()
        .build();

        HttpClient client = HttpClient.newBuilder()
        .version(Version.HTTP_1_1)
        .followRedirects(Redirect.NORMAL)
        .connectTimeout(Duration.ofSeconds(5))
        .build();

        HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
        System.out.println(response.statusCode());
        
        return response.body();
    }
}

