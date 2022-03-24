package ro.ase.cts.exceptions;

public class StringMinLength extends Exception {
    @Override
    public String getMessage() {
        return "Lungimea nu este corecta! Trebuie >=5";
    }
}
