/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.natan.handlerequests.client;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.util.Scanner;
import java.net.URL;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author natan
 */
public class ClientRequet {
    public static void main(String[] args) {
        ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(10);
        for(int i = 0; i < 10; i++) {
            newFixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    URL url;
                    try {
                        
                        url = new URL("http://localhost:8080/handle");
                        String requestData = requestData(url);
                        System.out.println(String.format("Response: %s", requestData));

                    } catch (MalformedURLException ex) {
                        Logger.getLogger(ClientRequet.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (IOException ex) {
                        Logger.getLogger(ClientRequet.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
            });
        }
    }
    
    public static String requestData(URL url) throws IOException {
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

        try {
            InputStream in = urlConnection.getInputStream();

            Scanner scanner = new Scanner(in);
            scanner.useDelimiter("\\A");

            if(scanner.hasNext()) {
                return scanner.next();
            } else {
                return null;
            }
        } finally {
            urlConnection.disconnect();
        }
    }
}
