package model;

import annotation.Model;

/**
 * Created by romh on 03/03/2017.
 */

public class Transaction {
    private String iban;
    private String recipient;
    private String subject;
    private Double amount;
    private Double totalAmount;

    @Model(kind = "getter", name = "iban", returnType = "String")
    public String getIban() {
        return iban;
    }

    public void setIban(String iban) {
        this.iban = iban;
    }

    @Model(kind = "getter", name = "recipient", returnType = "String")
    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    @Model(kind = "getter", name = "amount", returnType = "Double")
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Model(kind = "getter", name = "totalAmount", returnType = "Double")
    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    @Model(kind = "getter", name = "subject", returnType = "String")
    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
