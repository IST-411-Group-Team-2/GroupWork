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
    
    //Handles HTTP response and return
    private void sendPost(String inf_toSend) throws Exception{
        String toSend = inf_toSend;
        String serverAddress = "http://localhost:8080"; //Server Connection (8080)
        URL url = new URL(serverAddress);
        try {
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection(); //HTTP URL
            connection.setDoOutput(true); //connection request properties
            connection.setRequestProperty("User-Agent", "NBClient");
            OutputStream toPost = connection.getOutputStream();
            PrintWriter out = new PrintWriter(toPost, true);
            out.println(toSend);
            int responseCode = connection.getResponseCode();
            System.out.println("Post Response Code: " + responseCode);
            if (responseCode == 200) { //sends response code
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

    
    private void sendGet() throws IOException {
        try{
            //set the Server Connection (8080)
            String serverAddress = "http://localhost:8080"; 
            URL url = new URL(serverAddress);
            //Connect to server
            java.net.HttpURLConnection connection = (java.net.HttpURLConnection) url.openConnection();
            //Establish the GET request
            connection.setRequestMethod("GET"); //connection request properties
            connection.setRequestProperty("User-Agent", "NBClient");
            //retrives response code
            int responseCode = connection.getResponseCode();
            System.out.println("Response Code: " + responseCode);
            //if responce code is valid, getResponce from server and print it
            if (responseCode == 200) {
                String response = getResponse(connection);
                System.out.println("response: " + response);
            } else { //if responce code is not valid, displays error message
                System.out.println("Bad Response Code: " + responseCode);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
    private String getResponse(java.net.HttpURLConnection connection){
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(connection.getInputStream()))){
            String inputLine;
            StringBuilder response = new StringBuilder();
            while ((inputLine = br.readLine()) != null){
                response.append(inputLine);
                response.append("\n");
            }
            br.close();
            return response.toString();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return "";
    }
}
