class Solution {
    public int largestAltitude(int[] gain) {
        int[] altitudes = new int[gain.length+1];
        altitudes[0] = 0;
        int max = 0;
        
        for(int i=1; i<altitudes.length; i++) {
        	int altitude = altitudes[i-1] + gain[i-1];
        	altitudes[i] = altitude;
        	max = Math.max(max, altitude);
        }
        
        return max;
    }
}