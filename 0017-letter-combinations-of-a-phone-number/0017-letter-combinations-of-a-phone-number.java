class Solution {
    public List<String> letterCombinations(String digits) {
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
        List<String> result = new ArrayList<>();
        dfs(0, "", digits, letters, result);
        return result;
    }

    public void dfs (int idx, String candidates, String digits, String[] letters, List<String> result) {
        if (idx == digits.length()) {
            result.add(candidates);
            return;
        }
        
        char digit = digits.charAt(idx);
        String options = letters[digit - '0'];
        for (int i = 0; i < options.length(); i++) {
            dfs(idx + 1, candidates + options.charAt(i), digits, letters, result);
        }
    }
}