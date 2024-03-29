class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        
        StringBuilder answer = new StringBuilder();
        
        String first = strs[0];
        String last = strs[strs.length - 1];
        int minLength = Math.min(first.length(), last.length());
        for(int i = 0; i < minLength; i++){
            if(first.charAt(i) != last.charAt(i)){
                return answer.toString();
            }
            answer.append(first.charAt(i));
        }
        
        return answer.toString();
    }
}