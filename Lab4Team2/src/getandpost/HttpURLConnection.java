package getandpost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URL;
import java.util.Scanner;
/*
Project: Lab 4 Group Work
Purpose Details: Get and Post
Course: IST 411
Author: Team 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/8/2023
Last Date Changed:2/8/2023
Revision: 1
*/
public class HttpURLConnection {
    public static void main(String args[]) throws Exception{
        while(true){
            System.out.println("Type diary entry: ");
            // Create scanner for user input
            Scanner scanner = new Scanner(System.in);
            // Get string from user
            String inputDiary = scanner.nextLine();
            // Establish URL connection
            HttpURLConnection connection = new HttpURLConnection();
            // Publish diary entry to server
            connection.sendPost(inputDiary);
            // Show previous diary entries
            connection.sendGet();
        }
    }
    
    private void sendPost(String inf_toSend) throws Exception{
        String toSend = inf_toSend;
        String serverAddress = "http://localhost:8080";
        URL url = new URL(serverAddress);
        try {
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestProperty("User-Agent", "NBClient");
            OutputStream toPost = connection.getOutputStream();
            PrintWriter out = new PrintWriter(toPost, true);
            out.println(toSend);
            int responseCode = connection.getResponseCode();
            System.out.println("Post Response Code: " + responseCode);
            if (responseCode == 200) {
                String response = getResponse(connection);
                System.out.println("Post Response Message: " + response.toString());
            }
            else {
                System.out.println("Bad Response Code: " + responseCode);
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }    
    }

    
    private void sendGet() throws Exception{
        
    }
    private String getResponse(java.net.HttpURLConnection connection){
        
    }
}
