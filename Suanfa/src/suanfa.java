/**
 * Created by Administrator on 2016/8/25 0025.
 */
public class suanfa {
    public static void main(String[] args) {
//        System.out.print((10 >> 2)&1);
        test3();
    }

    //一个数组中 其中一个数出现一次，其他数都出现两次 如何找到这个数
    //原理 相同的数亦或为0 a^b^a^b=(a^a)^(b^b)
    public static void test1() {
        int[] size = {2, 2, 1, 1, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 11};
        int value = 0;
        for (int j = 0; j < size.length; j++) {
            value ^= size[j];
        }
        System.out.println(value);
    }

    //如果一个数组中有两个数出现一次，其他都出现两次，找两个数
    public static void test2() {
        int[] size = {2, 2, 1, 1, 3, 3, 4, 4, 5, 13, 6, 6, 7, 7, 11, 5};
        int i, j, temp = 0;
        //整个数组一伙
        for (i = 0; i < size.length; i++) {
            temp ^= size[i];
        }
        //查找亦或结果第一个为1的是位置 说明在这个位置上是有问题的
        for (j = 0; j < 8; j++) {

            if (((temp >> j) & 1) == 1) {
                break;
            }
        }
        int pN1 = 0;
        int pN2 = 0;
        //这里是为了分组亦或 在某个位上相同的亦或不同的亦或不同的，分而治之
        for (i = 0; i < size.length; i++) {
            if (((size[i] >> j) & 1) == 1) {
                pN1 ^= size[i];
            } else {
                pN2 ^= size[i];
            }
        }
        System.out.println(pN1 + "");
        System.out.println(pN2 + "");
    }

    /**
     * 一个数组中只有一个数出现一次，其他数均出现三次
     */
    private static void test3() {
        int[] size = {11, 2, 2, 2, 3, 3, 3, 4, 4, 4};
        int i = 0, j = 0;
        int low = 0, hight = size.length - 1;
        int bit = 1;
        int temp = 0;
        while (low <= hight) {
            if (low == hight) {
                temp = size[low];
                System.out.println(temp);
                return;
            }
            i = low - 1;
            //排列
            for (j = low; j <= hight; j++) {
                if ((size[j] & bit) == 0) {
                    i++;
                    size = swap(size, i, j);
                }
            }
            if (i >= low) {
                if ((i - low + 1) % 3 == 0) {
                    low = i + 1;
                } else hight = i;
            }
            bit = bit << 1;
        }

    }

    private static int[] swap(int[] size, int i, int j) {
        int k = 0;
        k = size[j];
        size[j] = size[i];
        size[i] = k;
        return size;
    }
}
