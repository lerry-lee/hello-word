package _设计模式._行为型._策略模式;

/**
 * @ClassName: MovieTicket
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description 环境类：电影票类
 */
public class MovieTicket {
    private double price;
    private Discount discount;//维持一个对抽象折扣类的引用

    public double getPrice() {
        return discount.calculate(this.price);
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Discount getDiscount() {
        return discount;
    }

    public void setDiscount(Discount discount) {
        this.discount = discount;
    }
}
