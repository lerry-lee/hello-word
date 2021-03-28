package _设计模式._行为型._迭代器模式;

import java.util.List;

/**
 * @ClassName: ProductList
 * @Author: lerry_li
 * @CreateTime: 2021/03/28
 * @Description 具体聚合类：商品数据类
 */
public class ProductList extends AbstractObjectList {
    public ProductList(List<Object> objects) {
        super(objects);
    }

    //实现创建迭代器对象的具体工厂方法
    @Override
    public AbstractIterator createIterator() {
        return new ProductIterator(this);
    }
}
