package app;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logic wallet = new Logic();

        while (true) {
            int option = Menu.showMenu(scanner);

            switch (option) {
                case 1:
                    Menu.showAddCurrency(scanner, wallet);
                    break;
                case 2:
                    Menu.showListCurrency(wallet);
                    break;
                case 3:
                    Menu.showRemoveCurrency(scanner, wallet);
                    break;
                case 4:
                    Menu.showTotalInBRL(wallet);
                    break;
                case 0:
                    System.out.println("Exiting...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Something went wrong.");
            }
        }
    }
}
