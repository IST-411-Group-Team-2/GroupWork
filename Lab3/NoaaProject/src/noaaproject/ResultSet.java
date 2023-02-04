package noaaproject;

import static java.lang.String.valueOf;


/*
Project: Lab 3
Purpose Details: Connections NOAA Web Services
Course: IST 411
Author: Group 2 (Aurora Blasko Drabik, Jang Won Cho, Tyler Cullen, Kaelynn Davies, Ian Gwillim, Andrew Kochhar, Ryan Waitlevertch)
Date Developed: 2/2/2023
Last Date Changed:2/2/2023
Revision: 1
*/
public class ResultSet {
    private int offset;
    private int count;
    private int limit;

    /**
     * @return the offset as a String
     */
    public String getOffset() {
        return valueOf(offset);
    }

    /**
     * @return the count as a String
     */
    public String getCount() {
        return valueOf(count);
    }

    /**
     * @return the limit as a String
     */
    public String getLimit() {
        return valueOf(limit);
    }
    
}
