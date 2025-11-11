package com.hub.br.symbiont.application.response;

public class SuccessResponse<T> implements ApiResponse {
    private final String status = "success";
    private final T data;

    public SuccessResponse(T data) {
        this.data = data;
    }

    @Override
    public String getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }
}