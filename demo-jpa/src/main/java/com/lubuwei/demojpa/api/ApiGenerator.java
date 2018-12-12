package com.lubuwei.demojpa.api;

/**
 * Created by Administrator on 2018/3/23.
 */
public class ApiGenerator {

    public static final  <T> Api<T> gen(String code, String msg, T data) {
        Api<T> api = new Api<T>();
        api.setCode(code);
        api.setMsg(msg);
        api.setData(data);
        return  api;
    }

    /**
     * 成功返回
     */
    public static final Api<String> ok() {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<String> api = gen(code, msg, "");
        return api;
    }

    /**
     * 成功返回
     */
    public static final <T> Api<T> ok(T data) {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<T> api = gen(code, msg, data);
        return api;
    }

    /**
     * 失败返回
     */
    public static final Api<String> fail() {
        String code = Code.FAILURE.getCode();
        String msg = Code.FAILURE.getMsg();
        Api<String> api = gen(code, msg, "");
        return api;
    }

    /**
     * 失败返回
     */
    public static final Api<String> fail(Code code) {
        Api<String> api = gen(code.getCode(), code.getMsg(), "");
        return api;
    }

    /**
     * 失败返回,自定义消息
     */
    public static final Api<String> fail(String msg) {
        String code = Code.FAILURE.getCode();
        Api<String> api = gen(code, msg, "");
        return api;
    }
}
