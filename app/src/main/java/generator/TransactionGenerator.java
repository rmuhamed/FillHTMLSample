package generator;

import model.Transaction;

/**
 * Created by romh on 03/03/2017.
 */

public class TransactionGenerator {

    public static Transaction dummyTransaction() {
        Transaction t = new Transaction();

        t.setRecipient("Adam Testington");
        t.setIban("DE32700222009510260101");
        t.setAmount(1000);

        return t;
    }

}
