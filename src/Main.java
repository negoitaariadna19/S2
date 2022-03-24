//package ro.ase.cts.lab02;

import ro.ase.cts.exceptions.IdentifierValueException;
import ro.ase.cts.exceptions.InvalidPriceValueException;
import ro.ase.cts.exceptions.PercentageValueException;
import ro.ase.cts.exceptions.StringMinLength;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws StringMinLength, InvalidPriceValueException, PercentageValueException, IdentifierValueException {

        OnlineShop onlineShop = new OnlineShop("Emag", "logo.jpg", new ArrayList<Product>());
        User user = new User("ariadna1088", 10, "Ariadna Negoita");
        Order order = new Order();
        Product p1 = new Product("Laptop", 3200.5, 1, "abc");
        Product p2 = new Product("Frigider", 207.95, 1, "def");

        Product p3 = new Product(p1);


        p1.applyAmountDiscount(10);
        p1.applyPercentageDiscount(0.25F);
        p2.increasePricePercentage(0.25F);
        System.out.println(p2);

        System.out.println(p1);
        onlineShop.addProductInList(p1);
        onlineShop.addProductInList(p2);
        onlineShop.removeProductFromList(p1);


        System.out.println(onlineShop);

        System.out.println(p1.equals(p2));
    }
}

class OnlineShop {
    private String name;
    private String image;
    private ArrayList<Product> products;

    public OnlineShop(String name, String image, ArrayList<Product> products) {
        this.name = name;
        this.image = image;
        this.products = products;
    }

    public void addProductInList(Product product) {
        this.products.add(product);

    }

    public void removeProductFromList(Product product) {
        this.products.remove(product);
    }

    @Override
    public String toString() {
        return "OnlineShop{" +
                "name='" + name + '\'' +
                ", image='" + image + '\'' +
                ", products=" + products +
                '}';
    }
}

class Product {

    private int id;
    private String Name;
    private double Price;
    private String description;

    public Product(String name, double price, int id, String description) throws StringMinLength, InvalidPriceValueException {

        if (name.length() >= 5) {
            this.Name = name;

        } else {
            throw new StringMinLength();
        }

        if (price > 0) {
            this.Price = price;
        } else {
            throw new InvalidPriceValueException();
        }
        this.id = id;
        this.description = description;
    }

    public Product(Product product) {
    }


    public boolean equals(Product p)//daca 2 produse sunt identice sau nu -> punem conditiile intr-un if
    {
        if ((p.id != this.id) && (!p.Name.equals(this.Name)) && (p.Price != this.Price))
            return false;


        return true;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                ", description='" + description + '\'' +
                '}';
    }

    public void applyPercentageDiscount(float percentageDiscount) throws PercentageValueException {
        if (percentageDiscount > 0 && percentageDiscount <= 1) {
            this.Price -= this.Price * percentageDiscount;
        } else {
            throw new PercentageValueException();

        }
    }

    public void applyAmountDiscount(double discountAmount) {
        this.Price -= discountAmount;
    }

    public void increasePricePercentage(float percentageIncrease) throws PercentageValueException {
        if (percentageIncrease > 0 && percentageIncrease <= 1) {
            this.Price += this.Price * percentageIncrease;
        } else {
            throw new PercentageValueException();

        }


    }

    public void increasePriceAmount(double increaseAmount) {
        this.Price += increaseAmount;
    }

}

class User {
    private String username;
    private Integer id;
    private String name;
    private ArrayList<Order> orderHistory;//orders-> toate comenzile
    private Cart shoppingCart;//card-> comanda nefinalizata

    public User(String username, Integer id, String name) throws StringMinLength, IdentifierValueException {
        if (username.length() >= 5) {
            this.username = username;
        } else {
            throw new StringMinLength();
        }

        if (id > 1) {
            this.id = id;
        } else {
            throw new IdentifierValueException();
        }

        if (name.length() > 10) {
            this.name = name;
        } else {
            throw new StringMinLength();
        }
    }

    public void addOrderToHistory(Order order) {
        this.orderHistory.add(order);
    }

    public void addProductToCart(Product product) {
        this.shoppingCart.add(product);//adauga in cos un order

    }
}


class Cart {
    private ArrayList<Product> products;

    public Cart() {
        products = new ArrayList<Product>();
    }

    public void add(Product product) {
        products.add(product);

    }
}

class Order {
    private ArrayList<Product> products;
    private String address;

    public Order() {
        products = new ArrayList<Product>();
    }

    public void add(Product product) {
        if (products.size() > 99)
            return;

        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }


}

class InventoryProduct {
    private Product product;
    private int quantiy;

    public InventoryProduct(Product product, int quantiy) throws InvalidPriceValueException, StringMinLength {
        this.product = new Product(product);
        this.quantiy = quantiy;
    }

}


