/**
 * Created by Administrator on 2016/8/29 0029.
 */
public class suzu {
    public static void main(String[] args) {
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
        for (int i=1;i<size.length;i++){
            for (int j=1;j<size[0].length;j++){
                if (size[i][j]==0){
                    size[i][0]=0;
                    size[0][i]=0;
                }
            }
        }
        //更新其他元素
        for (int i=1;i<size.length;i++){
            for (int j=1;j<size[0].length;j++){
                if (size[i][0]==0||size[0][j]==0){
                   size[i][j]=0;
                }
            }
        }
        //更新第一行
        if (isfirstLine){
             for (int i=0;i<size[0].length;i++){
                 size[0][i]=0;
             }
        }
        //更新第一列
        if (isfirstRow){
            for (int i=0;i<size.length;i++){
                size[i][0]=0;
            }
        }
    }
}
