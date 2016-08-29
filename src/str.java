/**
 * Created by Administrator on 2016/8/26 0026.
 */
public class str {
    public static void main(String[] args) {
        test1();
    }

    /**
     * 循环移位问题
     * 给定字符串S1 和S2
     * S1=ABCD 循环以为为BCDA,CDBA,DCBA,ABCD
     * 如果将S1移位保留
     * ABCD 移位为ABCDA ABCDAB ABCDABC
     * 以为后 为s1s1
     * 只要判断 s2是否为s1s1的字串
     */
    public static void test1() {
        String s1 = "AABCD";
        String s2 = "CDAA";
        String s3 = "ACBD";

        String s4 = s1 + s1;

        System.out.println(s4.contains(s2));
        System.out.println(s4.contains(s3));
    }

    /**
     * 给定两个字符串O和s 长度为m和n，判断s是否在o中出现，如果出现返回出现的位置
     */
    public static void KMP() {

    }

}
