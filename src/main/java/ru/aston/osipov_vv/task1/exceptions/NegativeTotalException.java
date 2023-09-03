package ru.aston.osipov_vv.task1.exceptions;

public class NegativeTotalException extends Exception {

    private final int errorCode;
    private final String errorDescription;

    public NegativeTotalException(int errorCode, String errorDescription) {
        this.errorCode = errorCode;
        this.errorDescription = errorDescription;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public String getErrorDescription() {
        return errorDescription;
    }
}
