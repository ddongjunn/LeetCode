class Solution {
    public List<String> letterCombinations(String digits) {
        String[] letters = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> letter = new ArrayList<>();

        if(digits.length() == 0){
            return letter;
        }

        Queue<String> q = new LinkedList<String>();
        q.add("");

        while (!q.isEmpty()) {
            String s = q.poll();
            if (s.length() != digits.length()){
                String word = letters[(digits.charAt(s.length()) - '0') - 2];
                for (int i=0; i<word.length(); i++){
                    q.add(s + word.charAt(i));
                }
            }else{
                letter.add(s);
            } 
        }
        return letter;
    }
}