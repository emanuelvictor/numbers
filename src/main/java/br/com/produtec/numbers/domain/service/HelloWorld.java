package br.com.produtec.numbers.domain.service;

import org.springframework.beans.factory.annotation.Autowired;

import javax.inject.Named;

@Named
public class HelloWorld {

    private String firstName = "John";
    private String lastName = "Doe";

    @Autowired
    NumbersService numbersService;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        System.out.println(numbersService.listByFilters(null, null));
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String showGreeting() {
        return "Hello " + firstName + " " + lastName + "!";
    }
}
