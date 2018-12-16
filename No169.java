public class No169 {
    public int majorityElement(int[] nums) {
        int clock = 0;
        int select = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (select == nums[i]) {
                clock += 1;
            } else {
                if (clock == 0) {
                    select = nums[i];
                } else {
                    clock--;
                }
            }
        }
        return select;
    }

    public static void main(String[] args) {
        No169 test = new No169();
        int[] nums = {3,3,3,2,2};
        System.out.println(test.majorityElement(nums));
    }
}
