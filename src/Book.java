import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Book extends  Product{
    private String authorFullname;

    public Book(String authorFullname) {
        this.authorFullname = authorFullname;
    }
    public  Book(){}

    @Override
    public Product[] addnewproduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        Book book = new Book();
        book.setId(MyGenereteId.geneteId());
        System.out.println("Названия книги:");
        book.setName(scanner.nextLine());
        System.out.println("Описание книги:");
        book.setDiscription(scanner.nextLine());
        System.out.println("Цена:");
        book.setPrice(new Scanner(System.in).nextBigDecimal());
        System.out.println("Введите автор:");
        book.setAuthorFullname(scanner.nextLine());
        book.setCreadAt(ZonedDateTime.now());
        products = Arrays.copyOf(products, products.length+1);
       products[products.length-1] = book;
       return products;
    }

    @Override
    public void getproducs(Product[] products) {
        for (Product product : products) {
            if (product instanceof Book book){
                System.out.println(book);
            }
            
        }

    }

    public Book(String name, String discription, BigDecimal price, String authorFullname) {
        super(name, discription, price);
        this.authorFullname = authorFullname;
    }

    public String getAuthorFullname() {
        return authorFullname;
    }

    public void  setAuthorFullname(String authorFullname) {
        this.authorFullname = authorFullname;

    }
}