package noaaproject;
/*
Project: Lab 3
Purpose Details: Connections NOAA Web Services
Course: IST 411
Author: Group 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/2/2023
Last Date Changed:2/2/2023
Revision: 1
*/
public class NoaaData {
    private Metadata metadata;
    private Results results[];
    
    public Metadata getMetadata(){
        return metadata;
    }
    public void setMetadata(Metadata md){
        this.metadata = md;
    }
    public Results[] getResults(){
        return results;
    }
    public void setResults(Results[] r){
        this.results = r;
    }
}
