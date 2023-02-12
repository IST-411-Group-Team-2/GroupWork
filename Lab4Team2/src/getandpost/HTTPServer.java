package getandpost;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.InetSocketAddress;

/*
Project: Lab 4 Group Work
Purpose Details: Get and Post
Course: IST 411
Author: Team 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/8/2023
Last Date Changed:2/9/2023
Revision: 2
 */
public class HTTPServer {

    public static void main(String[] args) throws IOException {
        // HTTP Server
        System.out.println("HTTPServer Started");
        // Create diary file
        initDiary();
        // Create listening server
        HttpServer server = HttpServer.create(new InetSocketAddress(8080), 0);
        // Create context
        server.createContext("/", new IndexHandler());
        // Start server
        server.start();
    }

    private static void initDiary() {
        //Diary is genreated to add entries to
        try {
            //Buffered Writer is made
            BufferedWriter writer = new BufferedWriter(new FileWriter("Diary.txt"));
            writer.write("");
            //Write is closed
            writer.close();
        } catch (IOException e) {
            //Exception thrown if file cannot be made
            System.out.println("Unable to create the diary file!");
        }
    }

    static class IndexHandler implements HttpHandler {

        // Handle the HTTP request sent by the client
        @Override
        public void handle(HttpExchange exchange) throws IOException {
            String requestMethod = exchange.getRequestMethod();
            System.out.println(requestMethod);
            System.out.println(exchange.getRemoteAddress());

            // Check if the HTTP request is a GET or a POST
            if (requestMethod.equalsIgnoreCase("POST")) {
                InputStream in = exchange.getRequestBody();
                String input = postInput(in);
                // Check if we are able to add the new diary entry. Returns Internal Server Error
                if (!addEntryToDiary(input)) {
                    String response = "ERROR - Unable to append to diary file.";
                    exchange.sendResponseHeaders(500, response.length());
                    OutputStream out = exchange.getResponseBody();
                    out.write(response.toString().getBytes());
                    out.close();
                    return;
                }
                // If successful, return OK to the client
                String response = "OK";
                exchange.sendResponseHeaders(200, response.length());
                OutputStream out = exchange.getResponseBody();
                out.write(response.toString().getBytes());
                out.close();
            } else if (requestMethod.equalsIgnoreCase("GET")) { // Handle the GET request
                String response = getDiaryEntries();
                exchange.sendResponseHeaders(200, response.length());
                OutputStream out = exchange.getResponseBody();
                out.write(response.toString().getBytes());
                out.close();
            } else { // Handle a request that is not GET or POST. Returns Bad Request
                System.out.println("NOT GET/POST" + requestMethod);
                String response = "Error - not a GET/POST request";
                exchange.sendResponseHeaders(400, response.length());
                OutputStream out = exchange.getResponseBody();
                out.write(response.toString().getBytes());
                out.close();
            }

        }

        // Get the diary entries
        private String getDiaryEntries() {
            // Try to open Diary.txt and return all entries
            try ( BufferedReader br = new BufferedReader(new FileReader("Diary.txt"))) {
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = br.readLine()) != null) {
                    response.append(inputLine);
                    response.append("\n");
                }
                br.close();
                return response.toString();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return ("");
        }

        // Parse the POST request from the client
        private String postInput(InputStream in) {
            if (in != null) {
                try ( BufferedReader br = new BufferedReader(new InputStreamReader(in));) {
                    String inputLine;
                    StringBuilder response = new StringBuilder();
                    while ((inputLine = br.readLine()) != null) {
                        response.append(inputLine);
                    }
                    br.close();
                    return response.toString();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            } else {
                System.out.println("Request body is empty");
            }

            return ("");
        }

        // Add the client's diary entry to the text file
        public static boolean addEntryToDiary(String entry) {
            try {
                //Create a buffered writer 
                BufferedWriter out = new BufferedWriter(new FileWriter("Diary.txt", true));

                //Write an entry
                out.write(entry);
                //Write a new line
                out.write("\n");

                //Close the write
                out.close();

                //return true if write was successful
                return true;
            } catch (IOException e) {
                //Exception throws if write fails
                System.out.println("Error writing to diary.");

            }

            //Default return if write fails
            return (false);
        }
    }
}
