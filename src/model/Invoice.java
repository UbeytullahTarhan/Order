package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Invoice extends ModelBaseImpl {

    private Firm firm;

    private Customer customer;

    private BigDecimal amount;

    private List<Product> products;
    public Invoice(Long id) {
        super(id);
    }

    public Invoice(Long id, LocalDate creationDate, Firm firm, Customer customer, List<Product> products) {
        super(id, creationDate);
        this.firm = firm;
        this.customer = customer;
        this.products = products;

        setAmount();
    }
    public Firm getCompany() {
        return firm;
    }

    public void setFirm(Firm firm) {
        this.firm = firm;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    private void setAmount() {
        amount = products.stream().map(Product::getPrice).reduce(BigDecimal.ZERO, BigDecimal::add);

    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
