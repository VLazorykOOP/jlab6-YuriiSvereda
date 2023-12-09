import javax.swing.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println(" Java Lab #6 ");
	// write your code here
        boolean exit = false;
        while(!exit) {
            System.out.println("choose task:");
            System.out.println("1. Task1;\n2. Task2.");
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    new MovingStrings();
                    break;
                case 2:
                    SwingUtilities.invokeLater(new Runnable() {
                        public void run() {
                            new Lab1Task3GUI().setVisible(true);
                        }
                    });
                    break;

                case -1:
                    exit = true;
                default:
                    System.out.println("there is no such option :(");
                    break;
            }
            System.out.println("========================================================================================\n\n\n\n\n");
        }

    }
}
