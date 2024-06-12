import java.util.Arrays;

class Solution {
    public int shipWithinDays(int[] weights, int days) {        
        int left = Arrays.stream(weights).max().getAsInt();
        int right = Arrays.stream(weights).sum();
        
        while(left < right) {
            int mid = left + (right - left) / 2;            
            if(condition(weights, mid, days)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }        
        return left;
    }
    
    public boolean condition(int[] weights, int capacity, int days) {
        int daysNeeded = 1;
        int currentWeight = 0;
        
        for(int weight : weights) {
            if(currentWeight + weight > capacity) {
                daysNeeded++;
                currentWeight = 0;
            }
            currentWeight += weight;
        }
        
        return daysNeeded <= days;
    }
}