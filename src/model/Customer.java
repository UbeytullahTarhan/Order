package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;




public class Customer extends ModelBaseImpl {
    Set<Invoice> invoices;
    String name;

    Set<Order> orders;
    final int LESS = -1;


    public Customer(Long id) {
        super(id);
    }

    public Customer(Long id, LocalDate creationDate,String name) {
        super(id, creationDate);
        this.name=name;
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }

    public BigDecimal getTotalInvoiceAmount() {
        return invoices.stream()
                .map(Invoice::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public boolean hasInvoiceUnderAmount(BigDecimal amount) {
        return invoices.stream()
                .anyMatch(i -> i.getAmount().compareTo(amount) == LESS);
    }
}
