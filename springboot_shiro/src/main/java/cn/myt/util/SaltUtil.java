package cn.myt.util;

/**
 * salt 的生成工具类
 *
 * @author mayating
 * @date 2021/10/17 10:48 下午
 */
public class SaltUtil {

    public static String getSalt(int n) {
        char[] chars = "ABCDEFGHIJKLMN0PQRSTUVWXYZabcdefghijklmn0pqrstuvwxyz0123456789~!@#$%^&*;'.,".toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            double random = Math.random() * 75;
            char ch = chars[(int) (Math.random() * 75)];
            stringBuilder.append(ch);
        }
        return stringBuilder.toString();
    }
}
