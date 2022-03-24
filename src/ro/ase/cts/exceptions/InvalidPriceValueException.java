package ro.ase.cts.exceptions;

public class InvalidPriceValueException extends Exception {
    @Override
    public String getMessage() {
        return "Pretul nu este corect";
    }

}
