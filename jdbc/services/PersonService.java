package jdbc.services;

import jdbc.repositories.CustomerRepository;
import part1and2.proiect.Person;

import java.awt.*;

public class PersonService {

    private static CustomerRepository customerRepository;

    public PersonService() {
        customerRepository = new CustomerRepository();
    }

    public static void adaugaPerson(String first_name, String last_nume, int age) {
        Person p = new Person(first_name,last_nume,age);
        customerRepository.adaugaPersoana(p);
    }

    public List getPerson() {
        return (List) customerRepository.findPerson();
    }

    public void delete(Person p) {
        customerRepository.stergePerson(p);
    }

}
