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
Last Date Changed:2/8/2023
Revision: 1
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
        
    }
    static class IndexHandler implements HttpHandler{
        @Override
        public void handle(HttpExchange exchange) throws IOException{
            
        }
        private String getDiaryEntries(){
            
        }
        private String postInput(InputStream in){
            
        }
        public static boolean addEntryToDiary(String entry){
            
        }
    }
}
