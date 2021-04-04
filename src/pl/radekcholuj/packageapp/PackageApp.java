package pl.radekcholuj.packageapp;

import java.util.Scanner;

public class PackageApp {
    public static void main(String[] args) {
        System.out.println("-------- Package APP --------");
        Scanner scanner = new Scanner(System.in, "UTF-8");


        Package<Shoes> shoesPackage = null;
        Package<Flour> flourPackage = null;
        Package<Cat> catPackage = null;

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
                            System.out.print("brand: ");
                            String brand = scanner.nextLine();
                            System.out.print("size: ");
                            int size = scanner.nextInt();
                            Shoes shoes = new Shoes(brand, size);
                            shoesPackage = new Package<>(shoes);
                            shoesPackage.send();
                            break;
                        case 2:
                            System.out.print("name: ");
                            String name = scanner.nextLine();
                            System.out.print("weight: ");
                            double weight = scanner.nextDouble();
                            Flour flour = new Flour(name, weight);
                            flourPackage = new Package<>(flour);
                            boolean sended = flourPackage.send();
                            break;
                        case 3:
                            System.out.print("name: ");
                            String catName = scanner.nextLine();
                            Cat cat = new Cat(catName);
                            catPackage = new Package<>(cat);
                            catPackage.send();
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
