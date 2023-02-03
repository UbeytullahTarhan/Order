package service;

import model.Customer;
import repository.CustomerRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomerService implements  BaseService<Customer> {
    private final CustomerRepository customerRepository;

    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Customer> getAll() {
        return customerRepository.getAll();
    }

    @Override
    public Customer getById(Long id) {
        return customerRepository.getById(id);
    }

    @Override
    public Customer add(Customer entity) {
        return customerRepository.add(entity);
    }


    public Set<Customer> getCustomersStartsWithLetter(String letter) {
        return customerRepository.getAll()
                .stream()
                .filter(c ->
                        c.getName().startsWith(letter))
                .collect(Collectors.toSet());
    }


    public List<Customer> getCustomerHaveInvoiceUnderAmount(BigDecimal amount) {
        return customerRepository.getAll().stream()
                .filter(c ->
                        c.hasInvoiceUnderAmount(amount))
                .collect(Collectors.toList());
    }
}
