package _设计模式._结构型._代理模式;

/**
 * @ClassName: Searcher
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description 抽象主题角色：抽象查询接口
 */
public interface Searcher {
    String doSearch(String userId, String keyWord);
}
