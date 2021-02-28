package _设计模式._结构型._代理模式;

/**
 * @ClassName: AccessValidator
 * @Author: lerry_li
 * @CreateTime: 2021/02/26
 * @Description 业务类：身份验证类
 */
public class AccessValidator {
    //模拟实现登录验证
    public boolean validate(String userId) {
        System.out.println("验证用户" + userId + "是否是合法用户？");
        if (userId.equals("杨过")) {
            System.out.println(userId + "登录成功");
            return true;
        } else {
            System.out.println(userId + "登录失败");
            return false;
        }
    }
}
