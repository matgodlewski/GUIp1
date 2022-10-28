package pl.edu.pjwstk.exceptions;

public class ProblematicTenantException extends Exception {

    // TODO: add below message to thrown exception

    // „Osoba X posiadała już najem pomieszczeń:
    // lista_pomieszczeń - wysokość_zadłużenia”,
    // gdzie X to imię i nazwisko danej osoby,
    // lista_pomieszczeń definiuje wynajmowane pomieszczenia,
    // zaś wysokość_zadłużenia definiuje sumaryczną wysokość zadłużenia za to pomieszczenie.

    public ProblematicTenantException() {
        super();
    }
}
