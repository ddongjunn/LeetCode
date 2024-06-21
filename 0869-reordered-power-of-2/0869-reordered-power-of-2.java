class Solution {
    public boolean reorderedPowerOf2(int n) {
        char[] arr = String.valueOf(n).toCharArray();
        Arrays.sort(arr);
        for(int i = 0; i < 30; i++) {
            char[] tmp = String.valueOf(1 << i).toCharArray();
            Arrays.sort(tmp);
            if(Arrays.equals(arr, tmp)) {
                return true;
            }
        }
        return false;
    }
}