class Solution {
    public int minDeletionSize(String[] strs) {
        int answer = 0;

        int row = strs[0].length();
        int col = strs.length;
        
        for (int i = 0; i < row; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < col; j++) {
                sb.append(strs[j].charAt(i));
            }

            char[] ch = sb.toString().toCharArray();
            char[] ch2 = sb.toString().toCharArray();
            Arrays.sort(ch2);
            for (int j = 0; j < ch.length; j++) {
                if (ch[j] != ch2[j]) {
                    answer++;
                    break;
                }
            }
        }

        return answer;
    }
}