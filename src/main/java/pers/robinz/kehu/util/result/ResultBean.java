package pers.robinz.kehu.util.result;

import java.io.Serializable;

/**
 * Created by Robinz on 2018-06-05.
 */
public class ResultBean<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    public static final int SUCCESS_CODE = 200;

    public static final int FAIL_CODE = 500;

    public static final String SUCCESS_MSG = "success";

    public static final String FAIL_MSG = "fail";

    public static final int NO_PERMISSION = 2;

    private String msg = SUCCESS_MSG;

    private int code = SUCCESS_CODE;

    //private int status = SUCCESS_CODE;

    private T data;

    public ResultBean() {
        super();
    }

    public ResultBean(T data) {
        super();
        this.data = data;
    }

    public ResultBean(Throwable e) {
        super();
        this.msg = e.toString();
        if (null != e.getMessage()) {
            this.msg = e.getMessage();
        }
        this.code = FAIL_CODE;
        //this.status = FAIL_CODE;
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

//    public int getStatus() {
//        return status;
//    }
//
//    public void setStatus(int status) {
//        this.status = status;
//    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
