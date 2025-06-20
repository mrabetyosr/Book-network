package tn.esprit.spring.booknetwork.exception;

public class OperationNoPermittedException extends RuntimeException {
    public OperationNoPermittedException(String msg) {
        super(msg);
    }
}
