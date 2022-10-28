package pl.edu.pjwstk.exceptions;

public class NeverRentException extends Exception{
    public NeverRentException() {
        super("The lease date has not been entered");
    }
}
