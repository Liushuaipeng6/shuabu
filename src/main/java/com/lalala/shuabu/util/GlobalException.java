package com.lalala.shuabu.util;

/**
 * 自定义异常
 *
 */
public class GlobalException extends RuntimeException {
    private static final long serialVersionUID = 1L;

    private String message;
    private int code = Const.ERROR_SYSTEM;  //默认500错误

    public GlobalException(String message) {
        super(message);
        this.message = message;
    }

    public GlobalException(String message, Throwable e) {
        super(message, e);
        this.message = message;
    }

    public GlobalException(String message, int code) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public GlobalException(String message, int code, Throwable e) {
        super(message, e);
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
