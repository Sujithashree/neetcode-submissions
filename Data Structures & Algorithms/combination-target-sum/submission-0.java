

class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();

        backtrack(nums, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] nums, int target, int index,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Found a valid combination
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Target became negative
        if (target < 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {

            // Choose nums[i]
            current.add(nums[i]);

            // Use i again because we can reuse the same number
            backtrack(nums, target - nums[i], i, current, result);

            // Undo the choice
            current.remove(current.size() - 1);
        }
    }
}