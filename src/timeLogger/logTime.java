package timeLogger;

import java.io.IOException;

/**
 * logTime
 */
public class logTime {

    private static long startTime;
    private static long stopTime;
    private static long elapsedTime;

    /*
     * Set and return the start time
     */
    public static double sTime() {

        return startTime = System.currentTimeMillis();
    }

    /*
     * Set end time and subtract start time to get elapsed time
     */
    public static double eTime() throws IOException {
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime;

        return elapsedTime;
    }

}