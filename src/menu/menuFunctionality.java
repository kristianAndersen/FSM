package menu;

import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import timeLogger.logTime;
import fileHandlers.listFiles;
import fileHandlers.fileInfo;

/**
 * menuFunctionality
 */
public class menuFunctionality {

    private Scanner input = new Scanner(System.in);
    private menuDisplay menuDisplay = new menuDisplay();
    private listFiles listFiles = new listFiles();
    private fileInfo fileInfo = new fileInfo();

    private boolean allowFileInfo = false;

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
             * match user input: is it a lowercase non charater and is it only 1
             * charraterlong
             */
            Pattern pat = Pattern.compile("^[a-zA-Z]{1}$");
            Matcher match = pat.matcher(mainChoise);

            /** Pick a number any number to select a file you want info about*/
            Pattern pat2 = Pattern.compile("^([0-9]|[1-9][0-9]|100)$");
            Matcher match2 = pat2.matcher(mainChoise);

            /**Search text for words that are longer than 
             * 2 characters and shorter than 100 includinhg a few special charaters
             * */
            Pattern pat3 = Pattern.compile("^[A-Za-zÀ-ȕ0-9(),-_.',]{2,100}+$");
            Matcher match3 = pat3.matcher(mainChoise);


            /** if user input mach a case satement then preform action */
            if (match.find()) {

                switch (mainChoise) {
                    case "a":
                        printIt("List all files");
                        listFiles.fileNames();
                        allowFileInfo = true;
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
            } else if (match2.find() && allowFileInfo == true) {

                int number = Integer.parseInt(mainChoise);
                printIt("File information");
                System.out.println(fileInfo.getFileInfo(number));

            } else if (match3.find()) {

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
        System.out.println("Execution time for " + toPrint + " was" + logTime.eTime() + " ms");
    }

    /**
     * Clear the terminal/console no need to have the window clutter up
     */
    private void clearterminal() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}