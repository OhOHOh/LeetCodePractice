#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    int minSubArrayLen(int target, vector<int>& nums) {
        int size = nums.size();
        int i = 0;
        int j = 0;
        int sum = 0;
        int length = size + 1;

        while (j < size)
        {
            sum += nums[j];
            while (sum >= target) {
                int tmp_len = j - i + 1;
                length = length < tmp_len ? length : tmp_len;
                sum -= nums[i];
                i += 1;
            }
            j += 1;
        }
        return length==(size+1) ? 0 : length;
    }
};