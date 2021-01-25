package timeLogger;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.io.File;
import java.util.concurrent.TimeUnit;


public class logTimeToFile {
    public static String writeTimeToFile(String fname,long elapsedTime) throws IOException {
        /**
         * Create and formate a Date with SimpleDateFormat
         */
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("E yyyy.MM.dd 'at' HH:mm:ss");
        long seconds = TimeUnit.MILLISECONDS.toSeconds(elapsedTime);

        String timeToLog=outFormat.format(now)+" execution time for "+fname+" was "+elapsedTime+" ms or "+seconds+" seconds"+System.lineSeparator();

        /**
         * get local directory so logfile can be 
         * written to the right folder
         */
        String localDir = System.getProperty("user.dir");
        Path filePath = Paths.get(localDir+ File.separator +"logfile"+ File.separator + "logfile.txt");
       
        /**
         * Write/append string to logfile
        */
        Files.write(filePath, timeToLog.getBytes(), StandardOpenOption.APPEND);

        return timeToLog;
    }
}
