package _设计模式._结构型._外观模式;

/**
 * @ClassName: EncryptFacade
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 外观类：加密外观类
 */
public class EncryptFacade {
    //维持对其它对象的引用
    private FileReader reader;
    private CipherMachine cipher;
    private FileWriter writer;

    public EncryptFacade() {
        reader = new FileReader();
        cipher = new CipherMachine();
        writer = new FileWriter();
    }

    //调用其它对象的业务方法
    public void FileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNameDes);
    }
}
