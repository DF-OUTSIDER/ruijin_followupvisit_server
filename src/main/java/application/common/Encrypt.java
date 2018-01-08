package application.common;

import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

public class Encrypt {
    public static String getMd5String(String text) throws Exception {
        if (!StringUtils.hasText(text))
            throw new Exception("No text");

        return DigestUtils.md5DigestAsHex(text.getBytes("UTF-8"));
    }
}
