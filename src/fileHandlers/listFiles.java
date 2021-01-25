package fileHandlers;

import java.io.File;

public class listFiles {

    public static File[] listOfFiles;
    private static filePaths filePaths = new filePaths();

    public static void fileNames() {
        System.out.println("\n");
        listOfFiles = filePaths.returnlistOfUsableFiles();
        int count = 0;

        String files;
        for (int i = 0; i < listOfFiles.length; i++) {

            files = listOfFiles[i].getName();
            /**
             * make sure it is not a hidden file print files out nicely arranged
             */
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

    public static void listFileByExtention(String fileExtention) {
        System.out.println("\n");
        boolean fextention;
        listOfFiles = filePaths.returnlistOfUsableFiles();

        int count = 0;

        String files;
        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                fextention = listOfFiles[i].getName().toLowerCase().endsWith(fileExtention);
                
                if (fextention) {
                    files = listOfFiles[i].getName();
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
}
