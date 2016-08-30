/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class suzu {
    public static void main(String[] args) {
        test2();
    }

    /**
     * 在一个二维数组中如果某一个元素为0，将其所在的行和列所以元素都设置为0，尽可能小的空间复杂度
     */
    static void test(int[][] size) {
        boolean isfirstLine = false;
        boolean isfirstRow = false;

//        判断第一行是否有值为0
        for (int i = 0; i < size[0].length; i++) {
            if (size[0][i] == 0) {
                isfirstLine = true;
                break;
            }
        }
        //判断第一列是否有值为0
        for (int i = 0; i < size[0].length; i++) {
            if (size[i][0] == 0) {
                isfirstRow = true;
                break;
            }
        }
        //先处理第一行第一列
        for (int i = 1; i < size.length; i++) {
            for (int j = 1; j < size[0].length; j++) {
                if (size[i][j] == 0) {
                    size[i][0] = 0;
                    size[0][i] = 0;
                }
            }
        }
        //更新其他元素
        for (int i = 1; i < size.length; i++) {
            for (int j = 1; j < size[0].length; j++) {
                if (size[i][0] == 0 || size[0][j] == 0) {
                    size[i][j] = 0;
                }
            }
        }
        //更新第一行
        if (isfirstLine) {
            for (int i = 0; i < size[0].length; i++) {
                size[0][i] = 0;
            }
        }
        //更新第一列
        if (isfirstRow) {
            for (int i = 0; i < size.length; i++) {
                size[i][0] = 0;
            }
        }
    }

    /**
     * 一个数组中，如果一个元素，大于右边的值大，那么这一对元素构成逆序对，求一个乱序数组中逆序对的数目
     */
    private static int CountInversions(int[] size) {
        int n = size.length;
        int[] temp = {size[0], size[size.length - 1]};
        int ans = MergeSortCount(size, 0, n - 1, temp);
        return ans;
    }

    private static int MergeSortCount(int[] a, int left, int right, int[] temp) {
        if (left >= right) return 0;

        int mid = (left + right) / 2;
        int Inverleft = MergeSortCount(a, left, mid, temp);
        int Inverright = MergeSortCount(a, mid + 1, right, temp);
        int InverSum = MergeCount(a, left, mid, right, temp);

        return Inverleft + Inverright + InverSum;
    }

    private static int MergeCount(int[] a, int left, int mid, int right, int[] temp) {
        int i = left;
        int j = mid + 1;
        int k = left;
        int count = 0;
        while (i <= mid && j <= right) {
            if (a[i] <= a[j])
                temp[k++] = a[i++];
            else {
                temp[k++] = a[j++];
                count += mid - i + 1;
            }
        }
        while (i <= mid) temp[k++] = a[i++];
        while (j <= right) temp[k++] = a[j++];

        for (i = left; i <= right; i++)
            a[i] = temp[i];
        return count;
    }

    private static void test2() {
        int[] size = {1, 2, 3, 4, 5, 6, 5, 4, 3, 2, 1, 2};
        System.out.print(CountInversions(size));
    }

}
