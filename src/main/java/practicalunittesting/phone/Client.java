package practicalunittesting.phone;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sharath on 4/10/15.
 */
public class Client {
    private final List<Phone> phones = new ArrayList<>();

    public void addPhone(Phone phone) {
        phones.add(phone);
    }

    public boolean hasMobile() {
        for(Phone p : phones) {
            if(p.isMobile())
                return true;
        }
        return false;
    }
}
