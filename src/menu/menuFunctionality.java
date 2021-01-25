package menu;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import timeLogger.logTime;
import fileHandlers.listFiles;

/**
 * menuFunctionality
 */
public class menuFunctionality {

    private Scanner input = new Scanner(System.in);
    private menuDisplay menuDisplay = new menuDisplay();
    private listFiles listFiles=new listFiles();

    public void menuFunctions() throws IOException {
        String mainChoise;
        menuDisplay.displayMenu();
        do {

            /**
             * wait for user input
             */

            mainChoise = input.nextLine();
            mainChoise = mainChoise.toLowerCase();
            /**
             * match user input: is it a lowercase non charater and is it only 1 charrater
             * long
             */
            Pattern pat = Pattern.compile("^[a-zA-Z]{1}$");
            Matcher match = pat.matcher(mainChoise);

            /** if user input mach a case satement then preform action */
            if (match.find()) {

                switch (mainChoise) {
                    case "a":
                        printIt("List all files");
                        listFiles.fileNames();
                        break;
                    case "b":
                        printIt("List PNG files");
                        listFiles.listFileByExtention(".png");
                        break;
                    case "c":
                        printIt("List JPG files");
                        listFiles.listFileByExtention(".jpg");
                        break;
                    case "d":
                        printIt("List JFIF files");
                        listFiles.listFileByExtention(".jfif");
                        break;
                    case "e":
                        printIt("List TXT files");
                        listFiles.listFileByExtention(".txt");
                        break;
                    case "q":
                        System.out.println("Exiting Program...");
                        System.exit(0);
                        break;
                }
            } else {
                String noInput = "sorry mate that was not an option in the menu! try again";
                printIt(noInput);
            }

        } while (mainChoise != "e");

    }

    /**
     * Clear terminal/console then display menu "GUI" and response to user input
     * 
     */
    private void printIt(String toPrint) throws IOException {
        clearterminal();
        menuDisplay.displayMenu();
        logTime.sTime();
        System.out.println("Execution time for "+toPrint+" was"+logTime.eTime()+" ms");
    }
    /**
     * Clear the terminal/console
     * no need to have the window clutter up
     */
    private void  clearterminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}