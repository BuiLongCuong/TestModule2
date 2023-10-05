public class Product {
    private int id;
    private String name;
    private int quantity;
    private int price;
    private String typeOfProduct;

    private static int idIncrement = 1;

    public Product(String name, int quantity, int price, String typeOfProduct) {
        this.id = idIncrement;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.typeOfProduct = typeOfProduct;
        idIncrement++;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getTypeOfProduct() {
        return typeOfProduct;
    }

    public void setTypeOfProduct(String typeOfProduct) {
        this.typeOfProduct = typeOfProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", quantity=" + quantity +
                ", price=" + price +
                ", typeOfProduct='" + typeOfProduct + '\'' +
                '}';
    }
}
