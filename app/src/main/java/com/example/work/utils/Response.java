package com.example.work.utils;

public class Response<T> {
    private Status status;
    private T data;
    private String message;

    private Response(Status status, T data, String message) {
        this.status = status;
        this.data = data;
        this.message = message;
    }

    public static <T> Response<T> success(T data) {
        return new Response<>(Status.SUCCESS, data, null);
    }

    public static <T> Response<T> error(T data, String message) {
        return new Response<>(Status.ERROR, data, message);
    }

    public static <T> Response<T> loading(T data) {
        return new Response<>(Status.LOADING, data, null);
    }

    public Status getStatus() {
        return status;
    }

    public T getData() {
        return data;
    }

    public String getMessage() {
        return message;
    }
}

