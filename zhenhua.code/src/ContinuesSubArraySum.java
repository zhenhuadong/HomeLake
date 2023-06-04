import java.util.HashMap;
import java.util.Map;

public class ContinuesSubArraySum {
    public static void main(String[] args){
        int[] nums = {1, 2, 12};
        int k=6;
        System.out.println(twoSum(nums,k));
    }
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> hashMap = new HashMap<>();

        for(int i=0; i<nums.length; i++){
            if(hashMap.containsKey(target-nums[i])){
                return new int[]{hashMap.get(target-nums[i]), i};
            }
        }
        return null;
    }
    public static boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums.length == 0){
            return false;
        }
        int sum=nums[0];
        for(int i=1; i <nums.length; i++) {
            sum += nums[i];
            if(sum % k == 0){
                return true;
            }else if (!map.containsKey(sum % k)) {
                map.put(sum % k, i+1);
            } else if (map.get(sum % k) < i) {
                return true;
            }
        }
        return false;
    }
}
