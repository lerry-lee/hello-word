package _设计模式._创建型._抽象工厂模式;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;

/**
 * @ClassName: XMLUtil
 * @Author: lerry_li
 * @CreateTime: 2021/02/23
 * @Description
 */
public class XMLUtil {
    //该方法用于从XML配置文件中提取具体类名，并返回一个实例对象
    public static Object getBean() {
        try {
            //创建文档对象
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new File("src/main/java/_设计模式/_抽象工厂模式/config.xml"));

            //获取包含类名的文本节点
            NodeList nodeList = doc.getElementsByTagName("className");
            Node node = nodeList.item(0).getFirstChild();
            String name = node.getNodeValue();

            //通过类名生成实例对象并将其返回
            //使用包路径
            Class c = Class.forName("_设计模式._创建型._抽象工厂模式." + name);
            Object obj = c.newInstance();
            return obj;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
