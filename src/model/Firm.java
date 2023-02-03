package model;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

public class Firm extends ModelBaseImpl {
    private Sector sector;

    private String name;

    private Set<Invoice> invoices;

    public Firm(Long id,String name) {
        super(id);
        this.name=name;
    }

    public Firm(Long id, LocalDate creationDate) {
        super(id, creationDate);
    }
    public Firm(Long id, LocalDate creationDate, Sector sector, String name, Set<Invoice> invoices) {
        super(id, creationDate);
        this.sector = sector;
        this.name = name;
        this.invoices = invoices;
    }

    public BigDecimal getAverageInvoice() {
        return invoices.stream().map(Invoice::getAmount).reduce(BigDecimal.ZERO, BigDecimal::add).divide(BigDecimal.valueOf(invoices.size()));
    }

    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Invoice> getInvoices() {
        return invoices;
    }

    public void setInvoices(Set<Invoice> invoices) {
        this.invoices = invoices;
    }
}
