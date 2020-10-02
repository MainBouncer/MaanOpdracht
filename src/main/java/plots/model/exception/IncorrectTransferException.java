package plots.model.exception;

public class IncorrectTransferException extends Exception {
    public IncorrectTransferException() {
        super();
    }

    public IncorrectTransferException(String message) {
        super(message);
    }

    public IncorrectTransferException(String message, Throwable cause) {
        super(message, cause);
    }
}
