package model;

import java.time.LocalDate;
import java.util.List;

public class Order extends ModelBaseImpl {
    private Customer customer;

    private List<Product> products;
    public Order(Long id) {
        super(id);
    }

    public Order(Long id, LocalDate creationDate) {
        super(id, creationDate);
    }
}
