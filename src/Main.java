import java.util.Arrays;
import java.util.Scanner;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        User[] users = new User[0];
        User currentuser = null;
        Scanner scanner = new Scanner(System.in);


        Outerloop:
        while (true) {
            System.out.println("""
                    🟢1. Регистрация
                    🟢2. Логин
                    🔴3. Exit.
                    Выберите команду:
                           """);
            switch (scanner.nextLine().toLowerCase()) {
                case "1", "регистрация" -> {
                    User registerUser = User.registr(new User());
                    users = User.adArray(users, registerUser);
                }
                case "2", "логин" -> {
                    User loginuser = User.voiti(users);
                    currentuser = loginuser;

                    innerloop:
                    while (true) {
                        System.out.println("""
                              0. logout
                              1. add product
                              2. get all product
                              3. get all book
                              4. get all device
                              5. Delete id
                              6.Delete ids
                             Выберите команду:
                              """);
                        switch (scanner.nextLine().toLowerCase()) {
                            case "0", "logout" -> {
                                break innerloop;
                            }
                            case "1", "add" -> {
                                System.out.println("""
                                      Какой товар будете добавить?
                                      1. Book
                                      2. Device
                                      Выберите:""");
                                String sanemes = scanner.nextLine();
                                switch (sanemes.toLowerCase()) {
                                    case "1", "book" -> {
                                        Book product = new Book();
                                        if (currentuser != null) {
                                          Product[] products = product.addnewproduct(currentuser.getProducts());
                                            currentuser.setProducts(products);
                                            System.out.println("Товар успешно добавлен✅");
                                        }
                                    }
                                    case "2", "device" -> {
                                        Device product = new Device();
                                        if (currentuser != null) {
                                           Product[] products =  product.addnewproduct(currentuser.getProducts());
                                            currentuser.setProducts(products);
                                            System.out.println("Товар успешно добавлен");
                                        }
                                    }
                                }
                            }
                            case "2" -> {
                                if (currentuser != null) {
                                    Product.getall(currentuser.getProducts());
                                }
                            }
                            case "3" -> {
                                new Book().getproducs(currentuser.getProducts());
                            }
                            case "4" -> {
                                new Device().getproducs(currentuser.getProducts());
                            }
                            case "5"->{
                                System.out.println("Какой id удалить?");
                               Product[] products =  Product.deleteProduct(currentuser.getProducts(), scanner.nextLong());
                                currentuser.setProducts(products);
                                System.out.println("Товар успешно удален!✅");
                            }
                            case "6" -> {
                                System.out.println("Сколько id удалить?");
                                int length = scanner.nextInt();
                                long[] ids = new long[length];
                                for (int i = 0; i < length; i++) {
                                    System.out.println("Какой ids удалить?");
                                    ids[i] = scanner.nextLong();


                                }
                                Product [] newproducts =  Product.deleteProduct(currentuser.getProducts(),ids);
                                currentuser.setProducts(newproducts);
                                System.out.println("Товары успешно Удалены!✅");
                            }
                        }
                    }
                }
                case "3", "exit" -> {
                    System.err.println("Вы вышли из программы!");
                    break Outerloop;
                }
            }
        }
    }
}



