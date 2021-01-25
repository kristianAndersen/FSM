package timeLogger;

import java.io.IOException;

//import java.text.DateFormat;


public class logTime {

    private static long startTime;
    private static long stopTime;
    private static long elapsedTime;

/**Get start time */
    public static double sTime() {
    
        return startTime = System.currentTimeMillis();
    }
/**Get end time and subtract start time to get elapsed time*/
    public static double eTime() throws IOException {
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime ;
    
        return elapsedTime;
    }

  


}