class Solution {
    public int peakIndexInMountainArray(int[] arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                answer = i;
                max = arr[i];
            }
        }
        return answer;
    }
}