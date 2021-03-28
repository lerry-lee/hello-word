package _设计模式._行为型._迭代器模式;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: AbstractObjectList
 * @Author: lerry_li
 * @CreateTime: 2021/03/28
 * @Description 抽象聚合类
 */
public abstract class AbstractObjectList {
    protected List<Object> objects=new ArrayList<>();

    public AbstractObjectList(List<Object> objects) {
        this.objects = objects;
    }

    public void addObject(Object obj){
        objects.add(obj);
    }

    public void removeObject(Object obj){
        objects.remove(obj);
    }

    public List<Object> getObjects() {
        return objects;
    }

    //声明创建迭代器对象的抽象工厂方法
    public abstract AbstractIterator createIterator();
}
