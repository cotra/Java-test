package book.life.utils;

import org.springframework.util.DigestUtils;

/**
 * Created by Administrator on 2018/9/6.
 */
public class Common {
    public static String toMD5(String str) {
        return DigestUtils.md5DigestAsHex(str.getBytes());
    }
}
