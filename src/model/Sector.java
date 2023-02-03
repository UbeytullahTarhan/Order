package model;

import java.time.LocalDate;
import java.util.Set;

public class Sector extends ModelBaseImpl {

    private String name;

    private Set<Firm> firms;

    public Sector(Long id,String name) {
        super(id);
        this.name=name;
    }

    public Sector(Long id, LocalDate creationDate,String name) {
        super(id, creationDate);
        this.name=name;
    }

    public Sector(Long id, LocalDate creationDate, String name, Set<Firm> firms) {
        super(id, creationDate);
        this.name = name;
        this.firms = firms;
    }

    public Set<Firm> getCompanies() {
        return firms;
    }

    public void setFirms(Set<Firm> companies) {
        this.firms = companies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

