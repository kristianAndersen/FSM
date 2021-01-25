package menu;

public class menuDisplay {

    public void displayMenu() {

        /**
         *  the menu "GUI"
         */
        String menuDecoreTop = "=========================================================================================================================\n";
        String menuItems = "A. List all Files. || List all -> B. PNG files. C. JPG files. D. jfif fiiles. || E. List all txt files || Q. Exit program\n";
        String menuDecoreBottom = "=========================================================================================================================\n";

        System.out.println(menuDecoreTop + menuItems + menuDecoreBottom);

    }
    
}
