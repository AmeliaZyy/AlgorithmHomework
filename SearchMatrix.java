package algorithm;

public class SearchMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        //坐标轴法了
        int row = matrix.length-1, col = 0;
        while(row >= 0 && col < matrix[0].length){
            int num = matrix[row][col];
            if(num == target){
                return true;
            }else if(num > target){//比目标大，上移动一排
                row--;
            }else{//比目标小，列右移
                col++;
            }
        }
        return false;//遍历完了都还没找到，返回false
    }
}
