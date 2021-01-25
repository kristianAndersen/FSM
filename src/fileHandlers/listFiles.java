package fileHandlers;

import java.io.File;

public class listFiles {

    
    public static File[] listOfFiles;
    private static filePaths filePaths = new filePaths();

    public static void fileNames() {

        listOfFiles = filePaths.returnlistOfUsableFiles();
        int count = 0;
      
        String files;
        for (int i = 0; i < listOfFiles.length; i++) {

          
                files = listOfFiles[i].getName();
                /**make sure it is not a hidden file */
                if (files.charAt(0) != '.') {
                    if (count >= 3) {
                        count = 0;
                        System.out.printf("%-20s", i + " .) " + files + " ");
                        System.out.println("\n");
                    } else {
                        System.out.printf("%-20s", i + " .) " + files + " ");
                        count++;
                    }
                }

            
        }

    }

    
}
