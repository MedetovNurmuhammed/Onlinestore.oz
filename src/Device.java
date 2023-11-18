import java.math.BigDecimal;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;

public class Device extends  Product{
    private String brand;
    private  String color;
    private Boolean isnew;
    private int memory;

    public Device() {
    }

    @Override
    public Product[] addnewproduct(Product[] products) {
        Scanner scanner = new Scanner(System.in);
        Device device = new Device();
        device.setId(MyGenereteId.geneteId());
        System.out.println("Бренд:");
        device.setBrand(scanner.nextLine());
        System.out.println("isnew: true/false");
        device.setIsnew(scanner.nextBoolean());
        System.out.println("Color :");
        device.setColor(scanner.nextLine());
        System.out.println("Память:");
        device.setMemory(scanner.nextInt());
        System.out.println("Цена:");
        device.setPrice(scanner.nextBigDecimal());
        device.setCreadAt(ZonedDateTime.now());
        Product[] newProductsArray = Arrays.copyOf(products, products.length+1);
        newProductsArray[newProductsArray.length-1] = device;
        return newProductsArray;
    }

    @Override
    public void getproducs(Product[] products) {
        for (Product product : products) {
            if (product instanceof Device device){
                System.out.println(device);
            }

        }

    }

    public Device(String name, String discription, BigDecimal price, ZonedDateTime creadAt,String brand, String color, Boolean isnew,int memory) {
        super(name, discription, price, creadAt);
        this.brand = brand;
        this.color = color;
        this.isnew = isnew;
        this.memory = memory;
    }

    public String getBrand() {
        return brand;
    }

    public Device setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Device setColor(String color) {
        this.color = color;
        return this;
    }

    public Boolean getIsnew() {
        return isnew;
    }

    public Device setIsnew(Boolean isnew) {
        this.isnew = isnew;
        return this;
    }

    public int getMemory() {
        return memory;
    }

    public Device setMemory(int memory) {
        this.memory = memory;
        return this;
    }

    @Override
    public String toString() {
        return "Device{" +
                "brand='" + brand + '\'' +
                ", color='" + color + '\'' +
                ", isnew=" + isnew +
                ", memory=" + memory +
                "} " + super.toString();
    }}


