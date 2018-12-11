package book.life.api;

/**
 * Created by Administrator on 2018/3/23.
 */
public enum Code {
    // 成功
    SUCCESS("0000", "操作成功"),
    // 失败
    FAILURE("1000", "操作失败"),
    FAILURE_HAS_STAFF("1000", "该手机已被注册"),
    FAILURE_HAS_GROUP("1000", "该管理组已存在")
    // 其它
    ;

    private final String code;
    private final String msg;

    private Code(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
