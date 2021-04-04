package pl.radekcholuj.packageapp;

import java.util.Scanner;

public class PackageApp {
    public static void main(String[] args) {
        System.out.println("-------- Package APP --------");
        Scanner scanner = new Scanner(System.in, "UTF-8");


        Package<Shoes> shoesPackage = null;
        Package<Flour> flourPackage = null;

        int option;
        do {
            System.out.println("1 - send package");
            System.out.println("2 - receive package");
            option = scanner.nextInt();

            displaySubMenu();
            switch (option) {
                case 1:
                    option = scanner.nextInt();
                    scanner.nextLine();
                    switch (option) {
                        case 1:
                            System.out.print("price: ");
                            double price = scanner.nextInt();
                            System.out.print("brand: ");
                            String brand = scanner.nextLine();
                            System.out.print("size: ");
                            int size = scanner.nextInt();
                            Shoes shoes = new Shoes(price,brand, size);
                            shoesPackage = new Package<>(shoes);
                            shoesPackage.send();
                            break;
                        case 2:
                            System.out.print("price: ");
                            double flourPrice = scanner.nextInt();
                            System.out.print("name: ");
                            String name = scanner.nextLine();
                            System.out.print("weight: ");
                            double weight = scanner.nextDouble();
                            Flour flour = new Flour(flourPrice, name, weight);
                            flourPackage = new Package<>(flour);
                            boolean sended = flourPackage.send();
                            break;
                    }
                    break;
                case 2:
                    option = scanner.nextInt();
                    switch (option) {
                        case 1:
                            Shoes shoes = shoesPackage.receive();
                            break;
                        case 2:
                            Flour flour = flourPackage.receive();
                            break;
                    }
            }

        } while (option != -1);
    }

    private static void displaySubMenu() {
        System.out.println("1 - shoes");
        System.out.println("2 - flour");
        System.out.println("3 - cat");
    }
}
