package _设计模式._结构型._外观模式;

/**
 * @ClassName: AbstractEncryptFacade
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 抽象外观类：加密类
 */
public abstract class AbstractEncryptFacade {
    public abstract void FileEncrypt(String fileNameSrc, String fileNameDes);
}
