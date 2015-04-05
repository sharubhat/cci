package practicalunittesting;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 4/4/15.
 */
public class Client {

    private List<Address> addresses;

    public Client() {
        this.addresses = new ArrayList<>();
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void addAddress(Address address) {
        addresses.add(address);
    }
}
