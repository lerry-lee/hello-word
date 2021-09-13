import java.util.HashMap;
import java.util.ListIterator;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @ClassName: main
 * @Author: lerry_li
 * @CreateTime: 2021/03/03
 * @Description
 */
public class main {

    public static void main(String[] args) {
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(null,1);
        hashMap.put(1,2);
        System.out.println(hashMap.get(null));
        System.out.println(hashMap.containsKey(null));
    }
}
