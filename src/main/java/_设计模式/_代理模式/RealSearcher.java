package _设计模式._代理模式;

/**
 * @ClassName: RealSearcher
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description 真实主题角色：具体查询类
 */
public class RealSearcher implements Searcher {
    @Override
    public String doSearch(String userId, String keyWord) {
        System.out.println("用户" + userId + "使用关键词" + keyWord + "查询商务信息！");
        return "返回具体内容";
    }
}
