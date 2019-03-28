package com.zyse.design.untils;

import com.zyse.design.system.enums.ResultStatusCode;

/**
 * 进行封装页面请求返回结果
 * @description: 功能描述
 * @Author: 梦醒灬纠结
 * @Date: 2018/11/30 16:47
 */
public  class ResultUtil {
    /**
     * 返回的代码，0表示成功，其他表示失败
     */
    private int code;
    /**
     * 成功或失败时返回的错误信息
     */
    private String msg;
    /**
     * 成功时返回的数据信息
     *
     */
    private Object data;
    public ResultUtil(int code, String msg, Object data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResultUtil(ResultStatusCode resultStatusCode, Object data){
        this(resultStatusCode.getCode(), resultStatusCode.getMsg(), data);
    }

    public ResultUtil(int code, String msg){
        this(code, msg, null);
    }

    public ResultUtil(ResultStatusCode resultStatusCode){
        this(resultStatusCode, null);
    }


    public int getCode() {
        return code;
    }
    public void setCode(int code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }
}
