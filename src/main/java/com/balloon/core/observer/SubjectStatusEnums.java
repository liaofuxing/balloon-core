package com.balloon.core.observer;


/**
 * 主题状态枚举.
 *
 * <p>当该主题在通知一次后, 不再需要改主题发起通知任务后, 可以通过把该主题的状态修改为 "已通知". 不再使用该主题.</p>
 *
 * @author liaofuxing
 * @since 1.0.0
 */
public enum SubjectStatusEnums {

    NOT_NOTIFY(0, "未通知"),
    NOTIFY(1, "已通知");

    private String msg;
    private int code;

    SubjectStatusEnums(int code, String msg) {
        this.msg = msg;
        this.code = code;
    }

    // 普通方法
    public static String getMsg(int code) {
        for (SubjectStatusEnums s : SubjectStatusEnums.values()) {
            if (s.getCode() == code) {
                return s.msg;
            }
        }
        return null;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
