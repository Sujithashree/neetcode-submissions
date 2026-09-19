class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] letters = {
            "",     // 0
            "",     // 1
            "abc",  // 2
            "def",  // 3
            "ghi",  // 4
            "jkl",  // 5
            "mno",  // 6
            "pqrs", // 7
            "tuv",  // 8
            "wxyz"  // 9
        };

        backtrack(digits, 0, new StringBuilder(), result, letters);

        return result;
    }

    private void backtrack(String digits,
                            int index,
                            StringBuilder current,
                            List<String> result,
                            String[] letters) {

        // We have selected one letter for every digit
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        // Get letters corresponding to current digit
        String possibleLetters =
            letters[digits.charAt(index) - '0'];

        // Try every possible letter
        for (char ch : possibleLetters.toCharArray()) {

            // Choose
            current.append(ch);

            // Explore
            backtrack(digits, index + 1, current, result, letters);

            // Undo
            current.deleteCharAt(current.length() - 1);
        }
    }
}