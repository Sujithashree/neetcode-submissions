class Solution {

class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
}
TrieNode root = new TrieNode();
List<String> result = new ArrayList<>();
public List<String> findWords(char[][] board, String[] words) {
    // Build Trie
    for (String word : words) {
        insert(word);
    }
    int m = board.length;
    int n = board[0].length;
    // Start DFS from every cell
    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            dfs(board, i, j, root);
        }
    }
    return result;
}
private void insert(String word) {
    TrieNode node = root;
    for (char ch : word.toCharArray()) {
        int index = ch - 'a';
        if (node.children[index] == null) {
            node.children[index] = new TrieNode();
        }
        node = node.children[index];
    }
    node.word = word;
}
private void dfs(char[][] board, int i, int j, TrieNode node) {
    // Boundary check
    if (i < 0 || j < 0 ||
        i >= board.length || j >= board[0].length) {
        return;
    }
    char ch = board[i][j];
    // Already visited
    if (ch == '#') {
        return;
    }
    int index = ch - 'a';
    // Character not present in Trie
    if (node.children[index] == null) {
        return;
    }
    node = node.children[index];
    // Word found
    if (node.word != null) {
        result.add(node.word);
        // Avoid duplicate results
        node.word = null;
    }
    // Mark current cell visited
    board[i][j] = '#';
    // Explore four directions
    dfs(board, i + 1, j, node);
    dfs(board, i - 1, j, node);
    dfs(board, i, j + 1, node);
    dfs(board, i, j - 1, node);
    // Backtracking: restore character
    board[i][j] = ch;
}

}