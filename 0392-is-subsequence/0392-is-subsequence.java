class Solution {
    public boolean isSubsequence(String s, String t) {
		int sIdx = 0;
		int eIdx = 0;
		while(sIdx < s.length() && eIdx < t.length()) {
			if(s.charAt(sIdx) == t.charAt(eIdx)) {
				sIdx++;
			}
			eIdx++;
		}
		return s.length() == sIdx;
    }
}