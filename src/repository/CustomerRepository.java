package repository;

import model.Customer;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CustomerRepository implements  BaseRepository<Customer> {
    private final Set<Customer> customers;

    public CustomerRepository() {
        this.customers = new HashSet<>();
    }

    @Override
    public List<Customer> getAll() {
        return customers.stream().toList();
    }

    @Override
    public Customer getById(Long id) {

        return customers.stream()
                .filter(c -> c.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer add(Customer entity) {
        return customers.add(entity) ? entity : null;
    }
}
