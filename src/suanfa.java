/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class suanfa {
    public static void main(String[] args) {
        test1();
    }

    //一个数组中 其中一个数出现一次，其他数都出现两次 如何找到这个数
    public static void test1() {
        int[] size = {2, 2, 1,1, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7,11};
        int value =0;
        for (int j = 0; j < size.length; j++) {
            value ^= size[j];
        }
        System.out.print(value);
    }
}
