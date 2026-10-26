
class Solution {
public List generateParenthesis(int n) {
List result = new ArrayList<>();
backtrack(result, new StringBuilder(), 0, 0, n);
return result;
}

private void backtrack(List<String> result, StringBuilder current,
                       int open, int close, int n) {
    // If the string contains 2*n parentheses, it is complete
    if (current.length() == 2 * n) {
        result.add(current.toString());
        return;
    }
    // Add an opening parenthesis if fewer than n have been used
    if (open < n) {
        current.append('(');
        backtrack(result, current, open + 1, close, n);
        current.deleteCharAt(current.length() - 1);
    }
    // Add a closing parenthesis only if it won't be unmatched
    if (close < open) {
        current.append(')');
        backtrack(result, current, open, close + 1, n);
        current.deleteCharAt(current.length() - 1);
    }
}

}