import java.util.Arrays;
import java.util.Scanner;

public class User {
    private String firstName;
    private String lastName;
    private String email;
    private String password;
   private Product[] products = new Product[0];

    public User() {
    }

    public User(String firstName, String lastName, String email, String password,Product[] products) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.products = products;
    }

    public static User[] adArray(User[] users, User registerUser) {

      User[] newArray =  users = Arrays.copyOf(users,users.length+1);
       newArray[newArray.length-1] = registerUser;
       return newArray;
    }


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;

    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
        this.products = products;
    }

    public  static User registr(User newuser) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя: ");
        newuser.setFirstName(scanner.nextLine());
        System.out.println("Фамилия: ");
        newuser.setLastName(scanner.nextLine());

        System.out.println("Введите Email:");
        newuser.setEmail(scanner.nextLine());
        if (newuser.getEmail().isEmpty() || newuser.getFirstName().isEmpty() || newuser.getLastName().isEmpty()) {
            System.out.println("Поля не могут быть пустыми!");}
         else if (!newuser.getEmail().contains("@gmail.com")) {
            System.out.println("Некорректный адрес электронной почты!");
        } else {
            System.out.println("Введите пароль: ");
            newuser.setPassword(scanner.nextLine());
            if (newuser.getPassword().length() < 4 ) {
                System.out.println("""
                        Пароль должен быть не менее 4 символа!❌" +
                                                  
                        """);
                return null;     }
            else {

            return newuser;

        }}
    return null;}

    public static User voiti(User[] users) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите email: ");
        String loginEmail = scanner.nextLine();
        System.out.print("Введите пароль: ");
        String loginPassword = scanner.nextLine();
        for (int i = 0; i < users.length; i++) {
            if (loginEmail.equals(users[i].getEmail()) && loginPassword.equals(users[i].getPassword())) {
                System.out.println("Вы вошли в аккаунт ✅");
                return users[i];
            }
        }
        System.out.println("Неверный email или пароль ❌");
        return null;
    }





    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +

                '}';
    }
}
