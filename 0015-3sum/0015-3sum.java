class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Set<String> set = new HashSet<>();

        List<List<Integer>> answer = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    String str = nums[i]+""+nums[left]+""+nums[right];
                    if (!set.contains(str)) {
                        set.add(str);
                        answer.add(List.of(nums[i], nums[left], nums[right]));    
                    }
                    left++;
                    right--;
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return answer;
    }
}