#include <iostream>
#include <vector>

using namespace std;

class Solution {
public:
    vector<int> sortedSquares(vector<int>& nums) {
        int size = nums.size();
        int left = 0;
        int right = size - 1;
        int index = right;
        vector<int> rtn(size, -1);

        while (index >= 0)
        {
            int lSqure = nums[left] * nums[left];
            int rSqure = nums[right] * nums[right];
            if (lSqure < rSqure) {
                rtn[index] = rSqure;
                right -= 1;
            } else {
                rtn[index] = lSqure;
                left += 1;
            }
            index -= 1;
        }
        return rtn;
    }
};