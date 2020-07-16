package com.balloon.core.exception;

/**
 * 业务通用运行时异常
 */
public class BusinessRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    /**
     * 错误码
     */
    private int code;

    /**
     * 返回信息
     */
    private String message;

    /**
     * 异常
     */
    private Throwable cause;

    public BusinessRuntimeException(int code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

    public BusinessRuntimeException(int code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
        this.message = message;
        this.cause = cause;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public Throwable getCause() {
        return cause;
    }

    public void setCause(Throwable cause) {
        this.cause = cause;
    }
}
