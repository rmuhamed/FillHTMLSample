package generator;

import model.Transaction;

/**
 * Created by romh on 03/03/2017.
 */

public class TransactionGenerator {

    public static Transaction dummyInstance() {
        Transaction t = new Transaction();

        t.setRecipient("Herr. Adam Testington");
        t.setIban("DE32700222009510260101");
        t.setAmount(Double.valueOf(1000));
        t.setTotalAmount(Double.valueOf(1000));

        return t;
    }

}
