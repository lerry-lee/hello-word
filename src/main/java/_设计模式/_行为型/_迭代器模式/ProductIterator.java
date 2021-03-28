package _设计模式._行为型._迭代器模式;

import java.util.List;

/**
 * @ClassName: ProductIterator
 * @Author: lerry_li
 * @CreateTime: 2021/03/28
 * @Description
 */
public class ProductIterator implements AbstractIterator {
    private ProductList productList;
    private List products;
    private int cursor1;//定义一个游标，用于记录正向遍历的位置
    private int cursor2;//定义一个游标，用于记录逆向遍历的位置

    public ProductIterator(ProductList productList) {
        this.productList = productList;
        products = productList.getObjects();
        cursor1 = 0;
        cursor2 = products.size() - 1;
    }

    @Override
    public void next() {
        if (cursor1 < products.size()) {
            cursor1++;
        }
    }

    @Override
    public boolean isLast() {
        return cursor1 == products.size();
    }

    @Override
    public void previous() {
        if (cursor2 > -1) {
            cursor2--;
        }
    }

    @Override
    public boolean isFirst() {
        return cursor2 == -1;
    }

    @Override
    public Object getNextItem() {
        return products.get(cursor1);
    }

    @Override
    public Object getPreviousItem() {
        return products.get(cursor2);
    }
}
