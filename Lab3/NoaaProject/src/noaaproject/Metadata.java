package noaaproject;
/*
Project: Lab 3
Purpose Details: Connections NOAA Web Services
Course: IST 411
Author: Group 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/2/2023
Last Date Changed:2/5/2023
Revision: 1
*/
public class Metadata {
    private ResultSet resultset;
    
    /**
     * @return the resultSet generated from the metadata
     */
    public ResultSet getResultSet(){
        return resultset;
    }
    
    
    public void setResultSet(ResultSet rs){
        this.resultset = rs;
    }
}
