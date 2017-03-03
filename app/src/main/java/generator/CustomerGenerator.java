package generator;

import model.Customer;

/**
 * Created by romh on 03/03/2017.
 */

public class CustomerGenerator {
    public static Customer dummyInstance() {
        Customer customer = new Customer();
        customer.setName("Herr. Ricardo Ángel Muhamed");
        customer.setBic("FDDODEMMXX");
        customer.setIban("DE59 70002 2200 9871 6652 22");

        return customer;
    }

}
