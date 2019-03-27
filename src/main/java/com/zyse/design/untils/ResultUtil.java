package com.zyse.design.untils;

/**
 * 进行封装页面请求返回结果
 * @description: 功能描述
 * @Author: 梦醒灬纠结
 * @Date: 2018/11/30 16:47
 */
public  class ResultUtil {

    /**
     状态码
     */
    private Integer code;
    /**
     * 状态
     */
    private Boolean isSuccess;
    /**
     * 成功或者失败消息
     */
    private String massege;
    /**
     * 数据对象
     */
    private Object result;
    /**
     * 构造无参方法
     */
    public ResultUtil() {
    }

    /**
     * 只返回状态，状态码
     * @param code 0:成功 1:成功但是没数据  -1失败
     * @param isSuccess 状态码
     */
    public ResultUtil(Integer code, Boolean isSuccess, String massege) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.massege = massege;
    }
    /**
     * 只返回状态，状态码，数据对象
     * @param code 0:成功 1:成功但是没数据  -1失败
     * @param isSuccess 状态码
     * @param result 数据对象
     */
    public ResultUtil(Integer code, Boolean isSuccess, Object result) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.result = result;
    }

    /**
     *返回全部信息即状态，状态码，消息，数据对象
     * @param code 0:成功 1:成功但是没数据  -1失败
     * @param isSuccess 状态码
     * @param massege 成功失败信息
     * @param result  数据对象
     */
    public ResultUtil(Integer code, Boolean isSuccess, String massege, Object result) {
        this.code = code;
        this.isSuccess = isSuccess;
        this.massege = massege;
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Boolean getSuccess() {
        return isSuccess;
    }
    public void setSuccess(Boolean success) {
        isSuccess = success;
    }

    public String getMassege() {
        return massege;
    }

    public void setMassege(String massege) {
        this.massege = massege;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}
