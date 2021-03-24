package _设计模式._结构型._外观模式;

/**
 * @ClassName: NewCipherMachine
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 子系统类：数据加密类
 */
public class NewCipherMachine {
    public String encrypt(String plainText) {
        //加密操作
        String encryptStr = new StringBuilder(plainText).reverse().toString();
        System.out.println("数据加密2：将明文转换为密文：" + encryptStr);
        return encryptStr;
    }
}
