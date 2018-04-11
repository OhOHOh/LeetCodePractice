
public class RemoveDuplicatesSortedArray { //第26题
    public int removeDuplicates(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int count = 1;

        for(int i = 1; i < nums.length; i++) {
            if(nums[i] != nums[i-1]) {
                nums[count++] = nums[i];
            }
        }
        return count;
    }

    public static void main(String args[]) {
        RemoveDuplicatesSortedArray test = new RemoveDuplicatesSortedArray();

        int[] nums = {4,5,5,5,5};
        System.out.println(test.removeDuplicates(nums));
    }
}
