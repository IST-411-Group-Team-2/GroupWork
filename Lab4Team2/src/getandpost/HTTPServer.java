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
    public static void main(String[] args) throws IOException{
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
    
    private static void initDiary(){
        //Diary is genreated to add entries to
        try{
           //Buffered Writer is made
           BufferedWriter writer = new BufferedWriter(new FileWriter("Diary.txt")); 
           writer.write("");
           //Write is closed
           writer.close();
        } catch(IOException e){
            //Exception thrown if file cannot be made
            System.out.println("Unable to create the diary file!");
        }
    }
    
    static class IndexHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            
        }
        private String getDiaryEntries(){
            
            return("");
        }
        private String postInput(InputStream in){
            
            return("");
        }
        public static boolean addEntryToDiary(String entry){
            try{
                //Create a buffered writer 
                BufferedWriter out = new BufferedWriter(new FileWriter("Diary.txt", true));
                
                //Write an entry
                out.write(entry);
                //Write a new line
                out.write("\n");
                
                //Close the write
                out.close();
                
                //return true if write was successful
            } catch(IOException e){
                //Exception throws if write fails
                System.out.println("Error writing to diary.");
                
            }
            
            //Default return if write fails
            return(false);
        }
    }
}
