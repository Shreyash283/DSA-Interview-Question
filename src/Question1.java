//Two Sum
import java.util.*;
class Question1 {
       HashMap<Integer,Integer>map = new HashMap<>();

       public void ops(int key, int value){
           map.put(key, value);
       }
       public int[] twoSum(int[] nums, int target){
           for(int i=0;i<nums.length;i++){
               for(int j = i+1; j<nums.length;j++){
                if(target == nums[i]+nums[j]){
                    return new int[]{i,j};
                }
                }
               }
           return new int[]{};
       }
    public static void main(String[] args) {
        Question1 obj = new Question1();

        int[] nums = {2,7,11,15};
        int target = 18;

        int[] result = obj.twoSum(nums,target);
        System.out.println("Indices: " + Arrays.toString(result));
    }
}
