package site.easy.to.build.crm.exception;

import org.apache.commons.csv.CSVRecord;

import jakarta.validation.ConstraintViolation;

public class LineError {
    private final String fileName;
    private final long lineNumber;
    private final String field;
    private final String message;
    private final String email;
    private final String name;

    public LineError(String fileName, long lineNumber, String field, String message, String email, String name) {
        this.fileName = fileName;
        this.lineNumber = lineNumber;
        this.field = field;
        this.message = message;
        this.email = email;
        this.name = name;
    }

    // Getters
    public String getFileName() {
        return fileName;
    }

    public long getLineNumber() {
        return lineNumber;
    }

    public String getField() {
        return field;
    }

    public String getMessage() {
        return message;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public static <T> LineError fromCsvRecord(CSVRecord record, String fileName,
            ConstraintViolation<T> violation,
            String email, String name) {
        return new LineError(
                fileName,
                record.getRecordNumber(),
                violation.getPropertyPath().toString(),
                violation.getMessage(),
                email,
                name);
    }
}