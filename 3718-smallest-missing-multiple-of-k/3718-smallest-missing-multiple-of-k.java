class Solution {
    public int missingMultiple(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int n : nums) {
            set.add(n);
        }

        for (int i = k; i <= 200; i += k) {
            if (!set.contains(i)) {
                return i;
            }
        }

        return 0;
    }
}