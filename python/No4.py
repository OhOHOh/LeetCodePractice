class Solution:
    def findMedianSortedArrays(self, nums1, nums2):
        len1, len2 = len(nums1), len(nums2)
        left, right = (len1+len2+1)//2, (len1+len2+2)//2
        return (self.fK(nums1, nums2, left) + self.fK(nums1, nums2, right)) / 2.0
    
    def fK(self, nums1, nums2, k):
        if len(nums1) == 0:
            return nums2[k-1]
        elif len(nums2) == 0:
            return nums1[k-1]
        if k == 1:
            return min(nums1[0], nums2[0])
        mid1_index = k//2-1 if k//2-1 < len(nums1) else len(nums1)-1
        mid2_index = k//2-1 if k//2-1 < len(nums2) else len(nums2)-1
        
        if nums1[mid1_index] < nums2[mid2_index]:
            return self.fK(nums1[mid1_index+1:], nums2, k-mid1_index-1)
        else:
            return self.fK(nums1, nums2[mid2_index+1:], k-mid2_index-1)
    
nums1 = [1,3]
nums2 = [2]
s = Solution()
print(s.findMedianSortedArrays(nums1, nums2))