package site.easy.to.build.crm.exception;

import java.util.List;

public class ImportException extends Exception {
    private final List<LineError> errors;

    public ImportException(String message, List<LineError> errors) {
        super(message);
        this.errors = errors;
    }

    public ImportException(String message, List<LineError> errors, Throwable cause) {
        super(message, cause);
        this.errors = errors;
    }

    public List<LineError> getErrors() {
        return errors;
    }
}