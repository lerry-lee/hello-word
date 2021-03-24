package _设计模式._结构型._外观模式;

/**
 * @ClassName: FileReader
 * @Author: lerry_li
 * @CreateDate: 2021/03/24
 * @Description 子系统类：文件读取类
 */
public class FileReader {
    public String read(String fileNameSrc) {
        //读文件
        String content = fileNameSrc;
        System.out.println("读取文件，获取明文：" + content);
        return content;
    }
}
