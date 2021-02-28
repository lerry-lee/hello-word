package _设计模式._结构型._代理模式;

/**
 * @ClassName: ProxySearcher
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description 代理主题角色：代理查询类
 */
public class ProxySearcher implements Searcher {

    private RealSearcher searcher = new RealSearcher();
    private AccessValidator validator;
    private Logger logger;

    @Override
    public String doSearch(String userId, String keyWord) {
        //如果身份验证成功，则执行查询
        if (this.validate(userId)) {
            String result = searcher.doSearch(userId, keyWord);
            this.log(userId);
            return result;
        }
        return null;
    }

    //创建访问验证对象并调用其validate()方法实现身份验证
    public boolean validate(String userId) {
        validator = new AccessValidator();
        return validator.validate(userId);
    }

    //创建日志记录对象并调用其log()方法实现日志记录
    public void log(String userId) {
        logger = new Logger();
        logger.log(userId);
    }
}
