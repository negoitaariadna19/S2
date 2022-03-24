package ro.ase.cts.exceptions;

public class PercentageValueException extends Exception {
    @Override
    public String getMessage() {
        return "Nu e ok discountul";
    }
}
