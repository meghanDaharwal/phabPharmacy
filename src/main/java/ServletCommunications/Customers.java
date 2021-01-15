package ServletCommunications;

import java.io.Serializable;
import java.util.List;

public class Customers implements Serializable {
    List<Customer> customers;
    public Customers(){

    }
    public void addCustomers(Customer customer) {

        this.customers.add(customer);
    }
    public List<Customer> getCustomers() {
        return customers;
    }
    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }
}
