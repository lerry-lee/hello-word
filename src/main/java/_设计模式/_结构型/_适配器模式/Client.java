package _设计模式._结构型._适配器模式;

/**
 * @ClassName: Client
 * @Author: lerry_li
 * @CreateDate: 2021/02/28
 * @Description
 */
public class Client {
    public static void main(String[] args) {
        //针对抽象目标接口编程
        ScoreOperation operation=new OperationAdapter();

        int[] scores={84,76,50,69,90,91,88,96,84};

        display(scores);

        operation.sort(scores);

        display(scores);

        System.out.println(operation.search(scores,96));
    }

    public static void display(int[] A){
        for(int num:A){
            System.out.print(num+" ");
        }
        System.out.println();
    }
}
