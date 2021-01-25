/**
 * Main
 */
import java.io.IOException;
import menu.menuFunctionality;
import timeLogger.logTime;

public class Main {

    public static void main(String[] args) throws IOException {

        logTime.sTime("Main method");
        menuFunctionality mFunc = new menuFunctionality();
        mFunc.menuFunctions();
        logTime.eTime();

    }
}