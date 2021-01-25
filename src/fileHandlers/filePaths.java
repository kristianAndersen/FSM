package fileHandlers;

import java.io.File;

public class filePaths {

    private String files;

    File[] returnlistOfUsableFiles() {
        /**
         * Get full path of all files in /resources foleder
         */
        String path = System.getProperty("user.dir") + File.separator + ".." + File.separator + "src" + File.separator
                + "resources";

        File filePaths = new File(path);
        File[] listOfFiles = filePaths.listFiles();
        File[] listOfUsableFiles = new File[listOfFiles.length - 1];
        /**
         * Copy the file array and remove unwanted hidden files. Ie. on mac the system
         * creates a .DS_Store file in any folder
         */
        for (int i = 0, j = 0; i < listOfFiles.length; i++) {
            files = listOfFiles[i].getName();

            if (files.charAt(0) != '.') {
                listOfUsableFiles[j++] = listOfFiles[i];
            }

        }

        return listOfUsableFiles;
    }

}
