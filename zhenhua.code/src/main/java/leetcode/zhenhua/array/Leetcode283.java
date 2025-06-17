package leetcode.zhenhua.array;

public class Leetcode283 {
    public void moveZeroes(int[] nums) {
        int count = 0;
        int k=0;
        for (int i = 0; i < nums.length; i++) {
            if(0 != nums[i]){
                nums[k++]=nums[i];
            }else{
                count++;
            }
        }
        for(int i=0; i< count; i++){
            nums[k++]=0;
        }
    }
}
