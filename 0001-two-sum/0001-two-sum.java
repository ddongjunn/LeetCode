class Solution {
    public int[] twoSum(int[] nums, int target) {
        // for (int i = 0; i < nums.length; i++) {
        //     for (int j = i + 1; j < nums.length; j++) {
        //         if (nums[i] + nums[j] == target) {
        //             return new int[]{i, j};
        //         }
        //     }
        // }
        // return new int[]{};

        // Arrays.sort(nums);
        // int left = 0;
        // int right = nums.length - 1;
        // while (left < right) {
        //     int sum = nums[left] + nums[right];

        //     if (sum == target) {
        //         return new int[]{left, right};
        //     }

        //     if (sum < target) {
        //         left++;
        //     } else {
        //         right--;
        //     }
        // }
        // return new int[]{};
        // 이 방법은 정렬하는 과정에서 문제에서 주어지 인덱스가 다르기 때문에 불가능 

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int t = target - nums[i];
            
            if (map.containsKey(t)) {
                return new int[]{map.get(t), i};
            }

            map.put(nums[i], i);
        }
        return new int[]{};
    }
}