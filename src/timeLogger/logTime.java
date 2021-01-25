package timeLogger;

import java.io.IOException;


public class logTime {

    private static long startTime;
    private static long stopTime;
    private static long elapsedTime;
    private static String funcName;

/**Get start time */
    public static double sTime(String fname) {
        funcName=fname;
        return startTime = System.currentTimeMillis();
    }
/**Get end time and subtract start time to get elapsed time*/
    public static double eTime() throws IOException {
        stopTime = System.currentTimeMillis();
        elapsedTime = stopTime - startTime ;
        
        logTimeToFile.writeTimeToFile(funcName, elapsedTime);
        return elapsedTime;
    }

  


}
//jar cfe FSM.jar main *.class fileHandlers/*.class menu/*.class timeLogger/*.class 
// javac -d out src/*.java src/fileHandlers/*.java src/menu/*.java src/timeLogger/*.java   
