package _设计模式._创建型._单例模式;

/**
 * @ClassName: SingletonEnum
 * @Author: lerry_li
 * @CreateTime: 2021/03/14
 * @Description 枚举类实现单例模式
 */
public class SingletonEnum {

    public static void main(String[] args) {
        World instance1=World.INSTANCE;
        World instance2=World.INSTANCE;
        System.out.println(instance1==instance2);
    }

    enum World {
        //唯一枚举
        INSTANCE;

        private String name = "world";

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
