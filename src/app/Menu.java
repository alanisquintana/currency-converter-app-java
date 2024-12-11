package app;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Menu {

    public static int showMenu(Scanner scanner) {

        System.out.println("\n------------ Menu ------------\n");
        System.out.println("1. Add currency");
        System.out.println("2. List currencies");
        System.out.println("3. Remove currency");
        System.out.println("4. Calculate total in Real");
        System.out.println("0. Exit\n");

        int option = -1;
        boolean validOption = false;

        while (!validOption) {
            System.out.print("Choose an option: ");

            String input = scanner.nextLine().trim();

            try {
                option = Integer.parseInt(input);

                if (option >= 0 && option <= 4) {
                    validOption = true;
                } else {
                    System.out.println("Please enter a valid option.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter an integer.");
            }
        }

        return option;
    }

    public static void showAddCurrency(Scanner scanner, Logic wallet) {

        while (true) {
            System.out.println("\n------------------------------\n");
            System.out.println("Choose the type of currency:");
            System.out.println("1. BRL (Brazilian Real)");
            System.out.println("2. USD (Dollar)");
            System.out.println("3. EUR (Euro)");
            System.out.println("0. Cancel");
            System.out.println("\nEnter your choice: ");

            int option = -1;

            while (option < 1 || option > 3) {
                try {
                    option = Integer.parseInt(scanner.nextLine().trim());

                    if (option
                            == 0) {
                        return;
                    }

                    if (option
                            < 1 || option
                            > 3) {
                        System.out.println("Por favor, insira uma opção válida.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número inteiro.");
                }
            }

            double valor = 0;
            boolean valorValido = false;

            while (!valorValido) {
                System.out.println("\n0. Cancelar");
                System.out.println("Digite o valor da moeda: ");
                String entrada = scanner.nextLine().trim().replace(",", ".");

                if (entrada.equals("0")) {
                    return;
                }

                try {
                    valor = Double.parseDouble(entrada);
                    valorValido = true;
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um valor válido.");
                }
            }

            switch (option
            ) {
                case 1:
                    wallet.addCurrency(new BRL(valor));
                    break;
                case 2:
                    wallet.addCurrency(new USD(valor));
                    break;
                case 3:
                    wallet.addCurrency(new EUR(valor));
                    break;
            }

            System.out.println("\nMoeda adicionada com sucesso.");
        }
    }

    public static void showListCurrency(Logic wallet) {

        if (wallet.currencies.isEmpty()) {
            System.out.println("\n------------------------------");
            System.out.println("\nO wallet está vazio.");
        } else {
            System.out.println("\n------------------------------");
            System.out.println("\nMoedas no Cofrinho:");
            for (int i = 0; i < wallet.currencies.size(); i++) {
                Currency currency = wallet.currencies.get(i);
                System.out.println((i + 1) + ". " + currency.getClass().getSimpleName() + " - " + currency.toString());
            }
        }
    }

    public static void showRemoveCurrency(Scanner scanner, Logic wallet) {

        while (true) {
            // Verifica se o wallet está vazio e retorna ao menu se estiver
            if (wallet.currencies.isEmpty()) {
                return;
            }

            // Exibe a lista de moedas, caso exista
            showListCurrency(wallet);

            int indice = -1;
            boolean indiceValido = false;

            // Valida o índice da moeda a ser removida
            while (!indiceValido) {
                System.out.println("\n0. Cancelar");
                System.out.println("Digite o número da moeda para remover: ");
                String entrada = scanner.nextLine().trim();

                if (entrada.equals("0")) {
                    return;
                }

                try {
                    indice = Integer.parseInt(entrada) - 1;

                    if (indice >= 0 && indice < wallet.currencies.size()) {
                        indiceValido = true;
                    } else {
                        System.out.println("Por favor, insira um índice válido.");
                    }

                } catch (NumberFormatException e) {
                    System.out.println("Por favor, insira um número inteiro.");
                }
            }

            // Chama a função para remover a moeda correspondente ao índice escolhido
            if (wallet.removeCurrency(indice)) {
                System.out.println("\nMoeda removida.");
            } else {
                System.out.println("\nÍndice inválido. Nenhuma moeda removida.\n");
            }
        }
    }

    public static void showTotalInBRL(Logic wallet) {

        NumberFormat nf = NumberFormat.getCurrencyInstance(Locale.of("pt", "BR"));

        System.out.println("\n------------------------------");
        System.out.println("\nTotal em Reais: " + nf.format(wallet.calculateTotalInBRL()));
    }
}
