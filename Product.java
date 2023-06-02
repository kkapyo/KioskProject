package Kiosk;


class Product extends Menu {
    private int price;
    private String category;

    public Product( String name, int price, String description, String category) {
        super(name, description);
        this.price = price;
        this.category = category;
    }

    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }
}
