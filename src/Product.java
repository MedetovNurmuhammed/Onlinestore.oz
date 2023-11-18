import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;

public abstract class Product {
    private long id;
    private String name;
    private String discription;
    private BigDecimal price;
     private ZonedDateTime creadAt;

    public Product(String name,String discription,BigDecimal price) {

        this.discription = discription;
        this.name = name;
        this.price = price;
    }
    public Product() {
    }

    public Product(String name,String discription,BigDecimal price,ZonedDateTime creadAt) {
        this.creadAt = creadAt;
        this.discription = discription;
        this.name = name;
        this.price = price;
    }

    public static void getall(Product[] products) {
        for (Product product : products) {
            System.out.println(product);

        }
    }

    public ZonedDateTime getCreadAt() {
        return creadAt;
    }

    public long getId() {
        return id;
    }

    public Product setId(long id) {
        this.id = id;
        return this;
    }

    public String getDiscription() {
        return discription;
    }

    public Product setDiscription(String discription) {
        this.discription = discription;
        return this;
    }

    public Product setCreadAt(ZonedDateTime creadAt) {
        this.creadAt = creadAt;
        return this;
    }


    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Product setPrice(BigDecimal price) {
        this.price = price;
        return this;
    }
    public abstract Product[] addnewproduct(Product[] products);
    public abstract void getproducs(Product[] products);
    public static Product[] deleteProduct(Product[] products,long id){
        for (int i = 0; i < products.length; i++) {
            if (products[i].getId() == id){
                for (int j = i; j < products.length-1; j++) {
                    products[j] = products[j+1];

                }
            }

        }
        return  Arrays.copyOf(products,products.length-1);

    }
    public static Product[] deleteProduct(Product[] products,long[] ids){
       for (int i = 0; i < ids.length; i++) {
           products= deleteProduct(products,ids[i]);
        }
return products;
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                "ID='" + id + '\'' +
                ", discription='" + discription + '\'' +
                ", price=" + price +
                ", creadAt=" + creadAt +
                '}';
    }
}