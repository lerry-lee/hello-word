package _设计模式._行为型._命令模式._请求日志;

import java.io.Serializable;

/**
 * @ClassName: ConfigOperator
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 请求接收者：配置文件操作类
 * 由于ConfigOperator类的对象是Command的成员对象，它也将随Command对象一起写入文件，因此ConfigOperator也需要实现Serializable接口
 */
public class ConfigOperator implements Serializable {
    public void insert(String args) {
        System.out.println("增加新节点：" + args);
    }

    public void modify(String args) {
        System.out.println("修改节点：" + args);
    }

    //省略删除方法
}
