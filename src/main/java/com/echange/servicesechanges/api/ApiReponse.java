package com.echange.servicesechanges.api;

public class ApiReponse {
    private String error;

    public String getError() {
        return error;
    }
    public void setError(String error) {
        this.error = error;
    }

    private Object data;

    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public ApiReponse() {}
    public ApiReponse(String error, Object data) {
        this.setError(error);
        this.setData(data);
    }
}
