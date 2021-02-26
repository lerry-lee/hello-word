package _设计模式._代理模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        Searcher searcher=new ProxySearcher();
        String result=searcher.doSearch("杨过","玉女心经");
        System.out.println(result);
    }
}
