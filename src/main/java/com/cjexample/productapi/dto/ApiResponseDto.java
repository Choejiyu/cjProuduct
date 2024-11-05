package com.cjexample.productapi.dto;

public class ApiResponseDto<T> {
    private String requestCode;
    private String requestMsg;
    private T data;

    // 생성자
    public ApiResponseDto(String requestCode, String requestMsg, T data) {
        this.requestCode = requestCode;
        this.requestMsg = requestMsg;
        this.data = data;
    }

    // Getter, Setter
    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getRequestMsg() {
        return requestMsg;
    }

    public void setRequestMsg(String requestMsg) {
        this.requestMsg = requestMsg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}