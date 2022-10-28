package pl.edu.pjwstk;

import pl.edu.pjwstk.exceptions.NeverRentException;

import java.time.DateTimeException;
import java.time.LocalDate;

public class Person {
    private String name;
    private String surname;
    private String pesel;
    private String address;
    private LocalDate dateOfBirth;
    private LocalDate firstLeaseDate;

    public Person(String name,
                  String surname,
                  String pesel,
                  String address,
                  String dateOfBirth) {

        setName(name);
        setSurname(surname);
        setPesel(pesel);
        setDateOfBirth(dateOfBirth);
        setAddress(address);
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPesel() {
        return pesel;
    }

    public String getAddress() {
        return address;
    }

    public String getDateOfBirth() {
        return dateOfBirth.toString();
    }

    public String getFirstLeaseDate() {
        try {
            if (firstLeaseDate == null)
                throw new NeverRentException();
            return firstLeaseDate.toString();
        } catch (NeverRentException exception) {
            return exception.getMessage();
        }
    }

    private void validateString(String text) {
        if (text == null)
            throw new RuntimeException(String.format("%s: The value entered cannot be null", getClass()));
        if (text.length() == 0)
            throw new RuntimeException(String.format("%s: The entered value cannot be empty", getClass()));
    }

    private void setName(String name) {
        validateString(name);
        this.name = name;
    }

    private void setSurname(String surname) {
        validateString(surname);
        this.surname = surname;
    }

    private void setPesel(String pesel) {
        if (pesel != null && pesel.length() == 11)
            this.pesel = pesel;
        else throw new RuntimeException("Incorrect Pesel entered");
    }

    private void setAddress(String address) {
        validateString(address);
        this.address = address;
    }

    private void validateDate(LocalDate date) {
        if (date.compareTo(LocalDate.now()) > 0) throw new DateTimeException("The entered date cannot be in the future");
    }
    private void setDateOfBirth(String dateOfBirth) {
        LocalDate parsedDateOfBirth = LocalDate.parse(dateOfBirth);
        validateDate(parsedDateOfBirth);
        this.dateOfBirth = parsedDateOfBirth;
    }

    public void setFirstLeaseDate(String firstLeaseDate) {
        LocalDate parsedFirstLeaseDate = LocalDate.parse(firstLeaseDate);
        validateDate(parsedFirstLeaseDate);
        this.firstLeaseDate = parsedFirstLeaseDate;
    }

    @Override
    public String toString() {
        return String.format("""
                        Person: {
                        \tName: %s,
                        \tSurname: %s,
                        \tPesel: %s,
                        \tDate of birth: %s,
                        \tAddress: %s,
                        \tFirst lease date: %s
                        }""",
                getName(), getSurname(), getPesel(), getDateOfBirth(), getAddress(), getFirstLeaseDate());
    }
}
