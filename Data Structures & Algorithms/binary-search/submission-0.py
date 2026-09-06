class Solution:
    def search(self, nums: List[int], target: int) -> int:
        
        left = 0
        right = len(nums) - 1

        while left <= right:
            mid = (left + right) // 2

            if nums[mid] == target:
                return mid

            elif nums[mid] < target:
                # Target is on the right side
                left = mid + 1

            else:
                # Target is on the left side
                right = mid - 1

        return -1