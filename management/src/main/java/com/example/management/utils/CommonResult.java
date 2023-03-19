package com.example.management.utils;


public class CommonResult<T> {
    private int code;
    private String message;
    private T data;

    public CommonResult(){

    }

    public CommonResult(T data){
        this.data = data;
    }

    public CommonResult(int code, String message, T data){
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public CommonResult(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static CommonResult success() {
        CommonResult result = new CommonResult<>();
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static <T> CommonResult<T> success(T data) {
        CommonResult<T> result = new CommonResult<>(data);
        result.setCode(200);
        result.setMessage("成功");
        return result;
    }

    public static CommonResult error(int code, String msg) {
        CommonResult result = new CommonResult();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

//    public static <T> CommonResult error(AppExceptionCodeMsg appExceptionCodeMsg){
//        CommonResult commonResult = new CommonResult(appExceptionCodeMsg.getCode(),appExceptionCodeMsg.getMsg(),null);
//        return commonResult;
//    }
}
