package com.lubuwei2.ssm.api;

/**
 * Created by Administrator on 2018/3/23.
 */
public class ApiGenerator {

    // 生成方法
    public static final <T> Api<T> gen(String code, String msg, T data) {
        Api<T> api = new Api<T>();
        api.setCode(code);
        api.setMsg(msg);
        api.setData(data);
        return api;
    }

    // 成功返回,无数据
    public static final <T> Api<T> ok() {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<T> api = gen(code, msg, null);
        return api;
    }

    // 成功返回,有数据
    public static final <T> Api<T> ok(T data) {
        String code = Code.SUCCESS.getCode();
        String msg = Code.SUCCESS.getMsg();
        Api<T> api = gen(code, msg, data);
        return api;
    }

    // 失败返回,默认msg
    public static final <T> Api<T> fail() {
        String code = Code.FAILURE.getCode();
        String msg = Code.FAILURE.getMsg();
        Api<T> api = gen(code, msg, null);
        return api;
    }

    // 失败返回,统一code
    public static final <T> Api<T> fail(Code code) {
        Api<T> api = gen(code.getCode(), code.getMsg(), null);
        return api;
    }

    // 失败返回,自定义信息
    public static final <T> Api<T> fail(String msg) {
        String code = Code.FAILURE.getCode();
        Api<T> api = gen(code, msg, null);
        return api;
    }
}
