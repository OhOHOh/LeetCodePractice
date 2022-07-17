#include <iostream>
#include <vector>

using namespace std;

//int main() {
//    cout << "hello world" << endl;
//    return 0;
//}
class Solution {
public:
    int search(vector<int>& nums, int target) {
        int left = 0;
        int right = nums.size() - 1;
        while (left <= right) {
            int middle = left + (right-left)/2;
            if (nums[middle] > target) {
                right = right - 1;
            } else if (nums[middle] < target) {
                left = left + 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
};

int main() {
    vector<int> vec = {-1,0,3,5,9,12};
    int target = 9;
    Solution s = Solution();
    cout << s.search(vec, target) << endl;
}
