package com.example.demo.bootstrap;

import com.example.demo.dao.CustomerRepository;
import com.example.demo.dao.DivisionRepository;
import com.example.demo.entities.Customer;
import com.example.demo.entities.Division;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


@Component
public class BootStrapData implements CommandLineRunner {
    private final CustomerRepository customerRepository;
    private final DivisionRepository divisionRepository;

    public BootStrapData(CustomerRepository customerRepository, DivisionRepository divisionRepository) {
        this.customerRepository = customerRepository;
        this.divisionRepository = divisionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        if (customerRepository.count() <= 1) {

            //Create First Customer and division

            Division firstDivision = new Division(); //

            firstDivision.setId(4L); // California
            firstDivision.setCountry_id(1L); //USA

            Customer firstCustomer = new Customer();


            firstCustomer.setFirstName("Freddy");
            firstCustomer.setLastName("Krueger");
            firstCustomer.setAddress("123 Elm Street");
            firstCustomer.setPostal_code("90210");
            firstCustomer.setPhone("(555) 123-4567");
            firstCustomer.setDivision(firstDivision);

            divisionRepository.save(firstDivision);
            customerRepository.save(firstCustomer);

            //Create second customer and division

            Division secondDivision = new Division(); //

            secondDivision.setId(61L); // Alberta
            secondDivision.setCountry_id(3L); // Canada

            Customer secondCustomer = new Customer();

            secondCustomer.setFirstName("Mick");
            secondCustomer.setLastName("Taylor");
            secondCustomer.setAddress("202 Spooky Springs Drive");
            secondCustomer.setPostal_code("T2N 1N4");
            secondCustomer.setPhone("(403) 456-7890");
            secondCustomer.setDivision(secondDivision);

            divisionRepository.save(secondDivision);
            customerRepository.save(secondCustomer);

            // Create third Customer and division

            Division thirdDivision = new Division(); //

            thirdDivision.setId(101L); // Alberta
            thirdDivision.setCountry_id(2L); // UK

            Customer thirdCustomer = new Customer();

            thirdCustomer.setFirstName("Michael");
            thirdCustomer.setLastName("Myers");
            thirdCustomer.setAddress("789 Sinister Street");
            thirdCustomer.setPostal_code(" W1A 1AA");
            thirdCustomer.setPhone("(020) 1234-5678");
            thirdCustomer.setDivision(secondDivision);

            divisionRepository.save(thirdDivision);
            customerRepository.save(thirdCustomer);

            //Create Fourth Customer

            Division fourthDivision = new Division(); //

            fourthDivision.setId(36L); // Oregon
            fourthDivision.setCountry_id(1L); // USA

            Customer fourthCustomer = new Customer();

            fourthCustomer.setFirstName("Pin");
            fourthCustomer.setLastName("Head");
            fourthCustomer.setAddress("4669 Basket Case Ave");
            fourthCustomer.setPostal_code("97266");
            fourthCustomer.setPhone("(503) 123-4567");
            fourthCustomer.setDivision(fourthDivision);

            divisionRepository.save(fourthDivision);
            customerRepository.save(fourthCustomer);

            //Create fifth customer

            Customer fifthCustomer = new Customer();
            fifthCustomer.setFirstName("Jason");
            fifthCustomer.setLastName("Voorhees");
            fifthCustomer.setAddress("626 Crystal Lake Circle");
            fifthCustomer.setPostal_code("97266");
            fifthCustomer.setPhone("(503) 123-4567");
            fifthCustomer.setDivision(fourthDivision);

            customerRepository.save(fifthCustomer);

        }

    }
}
