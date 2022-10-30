package cn.myspace.common;

import lombok.*;

import java.io.Serializable;
import java.util.HashMap;

/**
 * 统一返回结果类
 * 包含 Code码和Info描述
 */

@Data
public class Result extends HashMap<String, Object> implements Serializable {

    private static final long serialVersionUID = -3826891916021780628L;
    /** 状态码 */
    public static final String CODE_TAG = "code";

    /** 返回内容 */
    public static final String INFO_TAG = "info";

    /** 数据对象 */
    public static final String DATA_TAG = "data";

    /**
     * 初始化一个新创建的 Result 对象，使其表示一个空消息。
     */
    public Result() {
    }

    public Result(String code, String info) {
        super.put(CODE_TAG, code);
        super.put(INFO_TAG, info);
    }

    public Result(String code, String info, Object data) {
        this(code, info);
        if (data != null) {
            super.put(DATA_TAG, data);
        }
    }

    public Result(Result result) {
        this((String) result.get(CODE_TAG), (String) result.get(INFO_TAG), result.get(DATA_TAG));
    }

    /* 预置 */
    public static Result buildResult(Constants.ResponseCode code) {
        return new Result(code.getCode(), code.getInfo());
    }

    public static Result buildResult(Constants.ResponseCode code, Object data) {
        return new Result(code.getCode(), code.getInfo(), data);
    }

    /* 自定义 */

    public static Result buildResult(String code, String info) {
        return new Result(code, info);
    }

    public static Result buildResult(String code, String info, Object data) {
        return new Result(code, info, data);
    }

    /* 常用 */
    public static Result buildSuccessResult() {
        return buildResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo());
    }

    public static Result buildSuccessResult(Object data) {
        return buildResult(Constants.ResponseCode.SUCCESS.getCode(), Constants.ResponseCode.SUCCESS.getInfo(), data);
    }

    public static Result buildErrorResult() {
        return buildResult(Constants.ResponseCode.UNKNOWN_ERROR.getCode(), Constants.ResponseCode.UNKNOWN_ERROR.getInfo());
    }

    public static Result buildErrorResult(String info) {
        return buildResult(Constants.ResponseCode.UNKNOWN_ERROR.getCode(), info);
    }

}
