package noaaproject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import com.google.gson.Gson;
/*
Project: Lab 3
Purpose Details: Connections NOAA Web Services
Course: IST 411
Author: Group 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/2/2023
Last Date Changed:2/2/2023
Revision: 1
*/
public class Noaa {
    public static void main(String args[]){
        String accessToken = ""; // Needs to be added
        Gson gson = new Gson();
        String response;
        HttpURLConnection connection = null;
        try{
            URL url = new URL("https://www.ncdc.noaa.gov/cdo-web/api/v2/datasets");
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestProperty("token", accessToken);
            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            response = br.readLine();
            NoaaData noaa = gson.fromJson(response, NoaaData.class);
            
            System.out.println("Result Set");
            System.out.println("----------");
            System.out.println("%-15s%s\n", "Offset", noaa.getMetadata().getResultSet().getOffSet());
            System.out.println("%-15s%s\n", "Offset", noaa.getMetadata().getResultSet().getCount());
            System.out.println("%-15s%s\n", "Offset", noaa.getMetadata().getResultSet().getLimit());
            
            int count = 1;
            for(Results res : noaa.getResults()){
                System.out.println("Result " + count++);
                System.out.println("----------");
                System.out.println("%-15s%s\n", "Uid", res.getUid());
                System.out.println("%-15s%s\n", "Min Date", res.getMinDate());
                System.out.println("%-15s%s\n", "Max Date", res.getMaxDate());
                System.out.println("%-15s%s\n", "Name", res.getName());
                System.out.println("%-15s%s\n", "Data Coverage", res.getDatacoverage());
                System.out.println("%-15s%s\n", "ID", res.getID());
                System.out.println();
            }
        }
        catch (IOException ex){
            System.out.println(ex);
        }
        finally{
            connection.disconnect();
        }
    }
}
