package _设计模式._行为型._策略模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/03/25
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        MovieTicket mt = new MovieTicket();
        double originalPrice = 60.0;
        double currentPrice;

        mt.setPrice(originalPrice);
        System.out.println("原始价为：" + originalPrice);
        System.out.println("-----------------------------------");

        Discount discount;
        discount = new StudentDiscount();
        mt.setDiscount(discount);

        currentPrice = mt.getPrice();
        System.out.println("折后价为：" + currentPrice);
    }
}
