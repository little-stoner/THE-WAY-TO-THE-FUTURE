package com.stone.db.sqlinjection.core;

public class Result {

    private enum Message {
        SUCCESS("success"),
        FAILURE("failure")
        ;
        private final String msg;
        Message(String msg) {
            this.msg = msg;
        }
    }
    private enum Status {
        OK(1),
        NO(0),
        ;
        private final Integer status;
        Status(Integer status) {
            this.status = status;
        }
    }

    private String message;
    private Integer status;
    private Object data;

    private Result() {
    }

    private Result(String message, Integer status) {
        this.message = message;
        this.status = status;
    }

    private Result(String message, Integer status, Object data) {
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public static Result success() {
        return new Result(Message.SUCCESS.msg, Status.OK.status);
    }

    public static Result success(Object data) {
        return new Result(Message.SUCCESS.msg, Status.OK.status, data);
    }

    public static Result fail() {
        return new Result(Message.FAILURE.msg, Status.NO.status);
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
