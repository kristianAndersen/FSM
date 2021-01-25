package fileHandlers;

import java.io.File;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.imageio.ImageIO;

public class fileInfo {
    private static File[] listOfFiles;
    public static String extension;
    public static File txtFileToSearch;
    public static filePaths filePaths = new filePaths();

    public String getFileInfo(int num) throws IOException {

        listOfFiles = filePaths.returnlistOfUsableFiles();
        String fileName = listOfFiles[num].getName();

        /** Get file extention */
        int i = fileName.lastIndexOf('.');
        extension = fileName.substring(i + 1);
        extension.toLowerCase();

        
        File thefile = listOfFiles[num];
        
        /** Get file size in bytes */
        long bytes = thefile.length();
        /** convert to kilo/mega/giga bytes if needet*/
        long kilobytes = (bytes / 1024);
        long megabytes = (kilobytes / 1024);
        long gigabytes = (megabytes / 1024);

        long space = kilobytes;
        String spaceType = "kilobytes";

        if (megabytes != 0) {
            
            space = megabytes;
            spaceType = "megabytes";

        } else if (gigabytes != 0) {
            space = gigabytes;
            spaceType = "gigabytes";
        }

        String stringToReturn;

        if (extension.equals("txt")) {
            txtFileToSearch = thefile;
            stringToReturn = "\nThe file " + fileName + " takes up " + space + " " + spaceType
                    + " on your disc\nand have " + countTxtlines(thefile)
                    + " lines of text.\nYou can search this file for words. Type a word and press enter\n";

        } else {
            /** Get image size in pixels */
            BufferedImage bimg = ImageIO.read(thefile);
            int width = bimg.getWidth();
            int height = bimg.getHeight();

            stringToReturn = "\nThe file " + fileName + " is " + width + "x" + height + "px and takes up " + space + " "
                    + spaceType + " on your disc\n";
        }

        return stringToReturn;

    }


    /**read the text file and count it line by line */
    public static long countTxtlines(File thefile) {

        int linesCount = 0;
        try (BufferedReader buffRead = new BufferedReader(new FileReader(thefile))) {
            while (buffRead.readLine() != null) {
                linesCount++;
            }

        } catch (IOException e) {
            System.out.println("sorry shit went haywire and i have no clue\n " + e);
        }

        return linesCount;
    }
    
}
