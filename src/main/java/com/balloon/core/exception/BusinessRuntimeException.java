package com.balloon.core.exception;

/**
 * 业务通用运行时异常
 *
 * @author liaofuxing
 */
public class BusinessRuntimeException extends RuntimeException {
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

    /**
     * 使用通用化的异常枚举接口来构建业务运行时异常
     *
     * @param exceptionEnums 需要提供的异常枚举
     */
    public BusinessRuntimeException(IBaseExceptionEnums exceptionEnums) {
        super(exceptionEnums.getMsg());
        this.code = exceptionEnums.getCode();
        this.message = exceptionEnums.getMsg();
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
