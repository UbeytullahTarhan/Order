package utilitys;

import model.*;
import repository.*;
import service.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.Month;
import java.util.Arrays;
import java.util.Set;

public class createAndAllNecessaryMethods {
    FirmService firmService = new FirmService(new FirmRepository());

    SectorService sectorService = new SectorService(new SectorRepository());

    CustomerService customerService = new CustomerService(new CustomerRepository());

    ProductService productService = new ProductService(new ProductRepository());

    InvoiceService invoiceService = new InvoiceService(new InvoiceRepository());

    public createAndAllNecessaryMethods(){
        Firm firmOne = firmService.add(new Firm(0L,"Markafone"));
        Firm firmTwo = firmService.add(new Firm(1L, "Masis"));
        Firm firmThree = firmService.add(new Firm(2L, "BMW"));

        Sector sectorOne = sectorService.add(new Sector(0L, "Eğlence"));
        Sector sectorTwo = sectorService.add(new Sector(1L, "E-Ticaret"));
        Sector sectorThree = sectorService.add(new Sector(2L, "Otomotiv"));

        Customer customerOne = customerService.add(new Customer(0L, LocalDate.of(2021, Month.MARCH, 21), "Qerim"));
        Customer customerTwo = customerService.add(new Customer(1L, LocalDate.of(2023, Month.JUNE, 26), "Jane"));
        Customer customerThree = customerService.add(new Customer(2L, LocalDate.of(2022, Month.OCTOBER, 12), "Ali"));

        Product productOne = productService.add(new Product(0L, "productOne", BigDecimal.valueOf(345)));
        Product productTwo = productService.add(new Product(1L, "productTwo", BigDecimal.valueOf(567)));
        Product productThree = productService.add(new Product(2L, "productThree", BigDecimal.valueOf(90000)));

        Invoice invoiceOne = invoiceService.add(new Invoice(0L, LocalDate.of(2021, Month.MARCH, 21), firmOne, customerOne, Arrays.asList(productOne)));
        Invoice invoiceTwo = invoiceService.add(new Invoice(1L, LocalDate.of(2023, Month.JUNE, 26), firmTwo, customerTwo, Arrays.asList(productOne, productTwo)));
        Invoice invoiceThree = invoiceService.add(new Invoice(2L, LocalDate.of(2022, Month.OCTOBER, 12), firmThree, customerThree, Arrays.asList(productOne, productTwo, productThree)));


        sectorOne.setFirms(Set.of(firmOne));
        sectorTwo.setFirms(Set.of(firmTwo));
        sectorThree.setFirms(Set.of(firmThree));

        firmOne.setSector(sectorOne);
        firmTwo.setSector(sectorTwo);
        firmThree.setSector(sectorThree);

        firmOne.setInvoices(Set.of(invoiceOne));
        firmTwo.setInvoices(Set.of(invoiceTwo));
        firmThree.setInvoices(Set.of(invoiceThree));

        customerOne.setInvoices(Set.of(invoiceOne));
        customerTwo.setInvoices(Set.of(invoiceTwo));
        customerThree.setInvoices(Set.of(invoiceThree));
    }



    public void printAllCustomers() {
        System.out.println("All Customers ");
        customerService.getAll().stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public void printCustomersStartsWithLetter(String letter) {
        System.out.println("\n Customers Starts With 'C'");
        customerService.getCustomersStartsWithLetter(letter).stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public void printTotalInvoicesByCustomerRegistrationMonth(Month month) {
        System.out.println("\nTotal Invoices By Customer Registration Month : MARCH");
        System.out.println(invoiceService.getTotalInvoicesByCustomerRegistrationMonth(month));
    }

    public void printAllInvoices() {
        System.out.println("\n Get All Invoices");
        invoiceService.getAll().stream().forEach(i ->
                System.out.println(i.getId() + "\t" + i.getAmount() + "\t\t" + i.getCustomer().getName())
        );
    }

    public void printInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\n Get Invoices Over Amount : 1500 ");
        invoiceService.getInvoicesOverAmount(amount).stream().forEach(i ->
                System.out.println(i.getId() + "\t" + i.getAmount() + "\t" + i.getCustomer().getName())
        );
    }

    public void printAverageOfInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\nGet Average of Invoices Over Amount : 1500 ");
        System.out.println(invoiceService.getAverageOfInvoicesOverAmount(amount));
    }

    public  void printCustomersHaveInvoicesOverAmount(BigDecimal amount) {
        System.out.println("\n Get Customers Have Invoices Under Amount : 500 ");
        customerService.getCustomerHaveInvoiceUnderAmount(amount).stream().forEach(c ->
                System.out.println(c.getName())
        );
    }

    public  void printSectorsOfCompaniesHaveUnderAverageAmountOfInvoices(BigDecimal amount) {
        System.out.println("\nGet Sectors of Companies Have Under Average Amount of Invoices : 750 ");
        sectorService.getSectorOfCompaniesHaveInvoicesUnderAverageAmount(amount).stream().forEach(s ->
                System.out.println(s.getName())
        );
    }

}
