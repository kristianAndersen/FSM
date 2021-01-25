package timeLogger;

import java.io.IOException;

//import java.text.DateFormat;


public class logTime {

    private static long startTime;
    private static long stopTime;
    private static long elapsedTime;


    public static double sTime() {
    
        return startTime = System.currentTimeMillis();
    }

    public static Object eTime() throws IOException {
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime ;
    
        return elapsedTime;
    }

  


}