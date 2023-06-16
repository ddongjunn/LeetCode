class Solution {
    public int largestAltitude(int[] gain) {
        int altitudes = 0;
        int max = 0;
        for(int i=0; i<gain.length; i++) {
        	altitudes = altitudes + gain[i];
        	max = Math.max(altitudes, max);
        }
               
        return max;
    }
}