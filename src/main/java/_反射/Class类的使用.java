package _反射;

/**
 * @author lerrylee
 * @version 1.0.0
 * @className Class类的使用
 * @date 下午2:51 20-9-10
 * @description Class类的使用
 * 一切皆对象
 * 类是Class对象
 * Class的对象:类 的表示方式有三种
 * Class对象称为该类的类类型，可以通过类类型创建该类的对象
 **/
public class Class类的使用 {
    public static void main(String[] args) {
        Foo foo1 = new Foo();


        //任何一个类都是Class对实例对象，该实例对象有三种表示方式

        //1）任何一个类都有一个隐含的静态成员变量
        Class c1 = Foo.class;

        //2）已知该类的对象，通过getClass方法
        Class c2 = foo1.getClass();

        /*
        c1,c2表示了Foo类的类类型（class type）
        一切皆对象；
        类也是对象，是Class类的实例对象
        这个对象称为该类的类类型
         */

        System.out.println(c1 == c2);

        //3)Class.forName("类的全称")
        Class c3=null;
        try {
            c3= Class.forName("Foo");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(c2==c3);


        //可以通过类的类类型创建该类的实例对象-->通过c1/c2/c3创建Foo的实例
        try {
            Foo foo=(Foo)c1.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }

        foo1.display();
    }
}