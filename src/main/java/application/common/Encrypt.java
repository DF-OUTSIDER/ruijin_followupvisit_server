package application.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.DigestUtils;
import org.springframework.util.StringUtils;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Base64;

public class Encrypt {
    private final static Logger logger = LoggerFactory.getLogger(Encrypt.class);

    private static final String AES_KEY = "RXp*sn1RFR2U$P9&^YXN";
    private static byte[] key;
    private static SecretKeySpec secretKey;

    public static String getMd5String(String text) {
        try {
            if (!StringUtils.hasText(text))
                throw new Exception("No text");
            return DigestUtils.md5DigestAsHex(text.getBytes("UTF-8"));
        } catch (Exception e) {
            return "";
        }
    }

    private static void setKey(String myKey) {
        MessageDigest sha;
        try {
            key = myKey.getBytes("UTF-8");
            sha = MessageDigest.getInstance("SHA-1");
            key = sha.digest(key);
            key = Arrays.copyOf(key, 16);
            secretKey = new SecretKeySpec(key, "AES");
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
    }

    public static String encryptAES(String strToEncrypt) {
        return encryptAES(strToEncrypt, AES_KEY);
    }

    public static String encryptAES(String strToEncrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            return Base64.getEncoder().encodeToString(cipher.doFinal(strToEncrypt.getBytes("UTF-8")));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }

    public static String decryptAES(String strToDecrypt) {
        return decryptAES(strToDecrypt, AES_KEY);
    }

    public static String decryptAES(String strToDecrypt, String secret) {
        try {
            setKey(secret);
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5PADDING");
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            return new String(cipher.doFinal(Base64.getDecoder().decode(strToDecrypt)));
        } catch (Exception e) {
            logger.error(e.getMessage());
        }
        return null;
    }
}
