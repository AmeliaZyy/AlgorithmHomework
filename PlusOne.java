/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

来源：力扣（LeetCode）66题
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
class PlusOne {
    public int[] plusOne(int[] digits) {
        int a=digits.length-1;
        if(digits[a]!=9){
            digits[a]++;
            return digits;
        }

        while(digits[a]==9){
            if(a==0){
                digits= new int[digits.length+1];
                digits[0]=1;
                return digits;
            }
            digits[a]=0;
            a--;
        }
        digits[a]++;
        return digits;
    }
}