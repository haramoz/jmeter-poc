package dr.sattlers.bar.jmeterpoc.exception;

public class BarException extends Exception{
    public BarException(String message) {
        super(message);
    }

    public BarException(String message, Throwable cause) {
        super(message, cause);
    }
}
