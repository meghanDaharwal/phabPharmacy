package ServletCommunications;

import java.io.Serializable;

public class Customer implements Serializable {
    String address;
    String email;
    String first_name;
    int id;
    String last_name;
    String phone_no;
    String postcode;

    public Customer(String address, String email, String first_name, int id, String last_name, String phone_no, String postcode){
        this.address = address;
        this.email = address;
        this.first_name = address;
        this.id = id;
        this.last_name = last_name;
        this.phone_no = phone_no;
        this.postcode = postcode;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public int getId() {
        return id;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getPhone_no() {
        return phone_no;
    }

    public String getPostcode() {
        return postcode;
    }

}
