package com.hub.br.symbiont.application.response;

public class ErrorResponse implements ApiResponse {
    private final String status = "error";
    private final String message;
    private final String details;

    public ErrorResponse(String message, String details) {
        this.message = message;
        this.details = details;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public String getDetails() {
        return details;
    }
}
