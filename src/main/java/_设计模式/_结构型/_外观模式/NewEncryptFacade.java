package _设计模式._结构型._外观模式;

/**
 * @ClassName: NewEncryptFacade
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 具体外观类
 */
public class NewEncryptFacade extends AbstractEncryptFacade {

    private FileReader reader;
    private NewCipherMachine cipher;
    private FileWriter writer;

    public NewEncryptFacade() {
        reader=new FileReader();
        cipher=new NewCipherMachine();
        writer=new FileWriter();
    }

    @Override
    public void FileEncrypt(String fileNameSrc, String fileNameDes) {
        String plainStr = reader.read(fileNameSrc);
        String encryptStr = cipher.encrypt(plainStr);
        writer.write(encryptStr, fileNameDes);
    }
}
