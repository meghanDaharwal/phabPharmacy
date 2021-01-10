package ServletCommunications;

import java.io.Serializable;
import java.util.List;

public class Order implements Serializable {
    List<Product> products;
    int customer;
    public Order(List<Product> products, int customer){
        this.products = products;
        this.customer = customer;
    }
    public Order(){};
    public List<Product> getProducts() {
        return products;
    }
    public int getCustomer() {
        return customer;
    }
}
