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
public class Results {
    private String uid;
    private String mindate;
    private String maxdate;
    private String name;
    private String datacoverage;
    private String id;

    /**
     * @return the uid
     */
    public String getUid() {
        return uid;
    }

    /**
     * @param uid the uid to set
     */
    public void setUid(String uid) {
        this.uid = uid;
    }

    /**
     * @return the mindate
     */
    public String getMinDate() {
        return mindate;
    }

    /**
     * @param mindate the mindate to set
     */
    public void setMinDate(String mindate) {
        this.mindate = mindate;
    }

    /**
     * @return the maxdate
     */
    public String getMaxDate() {
        return maxdate;
    }

    /**
     * @param maxdate the maxdate to set
     */
    public void setMaxDate(String maxdate) {
        this.maxdate = maxdate;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the datacoverage
     */
    public String getDatacoverage() {
        return datacoverage;
    }

    /**
     * @param datacoverage the datacoverage to set
     */
    public void setDatacoverage(String datacoverage) {
        this.datacoverage = datacoverage;
    }

    /**
     * @return the id
     */
    public String getID() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setID(String id) {
        this.id = id;
    }
    
}
