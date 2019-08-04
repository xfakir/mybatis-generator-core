package org.mybatis.generator;

/**
 * @ClassName : MybatisUtils
 * @Description :
 * @Author : xfakir
 * @Date : 2019-07-01 20:13
 * @Version : 1.0
 */
public class MybatisUtils {
    /**
     * 将表名转换为类名
     * @param tableName
     * @return
     */
    public static String transferTableNameToClassName(String tableName) {
        char[] chars = tableName.toCharArray();
        chars[0] -= 32;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == '_') {
                chars[i + 1] -= 32;
            }
        }
        return new String(chars).substring(0,chars.length - 2).replace("_","").trim();
    }


}
