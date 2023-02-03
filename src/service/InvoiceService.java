package service;

import model.Customer;
import model.Invoice;
import repository.InvoiceRepository;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Month;
import java.util.List;
import java.util.stream.Collectors;

import static javax.xml.datatype.DatatypeConstants.GREATER;

public class InvoiceService implements  BaseService<Invoice> {
    private final InvoiceRepository invoiceRepository;

    public InvoiceService(InvoiceRepository invoiceRepository) {
        this.invoiceRepository = invoiceRepository;
    }

    @Override
    public List<Invoice> getAll() {
        return invoiceRepository.getAll();
    }

    @Override
    public Invoice getById(Long id) {
        return invoiceRepository.getById(id);
    }

    @Override
    public Invoice add(Invoice entity) {
        return invoiceRepository.add(entity);
    }


    public List<Invoice> getInvoicesOverAmount(BigDecimal amount) {
        return invoiceRepository.getAll().stream()
                .filter(i -> i.getAmount().compareTo(amount) == GREATER)
                .collect(Collectors.toList());
    }


    public BigDecimal getAverageOfInvoicesOverAmount(BigDecimal amount) {
        List<BigDecimal> total = getInvoicesOverAmount(amount)
                .stream()
                .map(Invoice::getAmount)
                .toList();

        if (total.size() == 0)
            return BigDecimal.ZERO;

        return total.stream().reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(total.size()), RoundingMode.UNNECESSARY);
    }


    public BigDecimal getTotalInvoicesByCustomerRegistrationMonth(Month month) {
        return invoiceRepository.getAll()
                .stream()
                .map(Invoice::getCustomer)
                .filter(c -> c.getCreationDate().getMonthValue() == month.getValue())
                .map(Customer::getTotalInvoiceAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }
}
