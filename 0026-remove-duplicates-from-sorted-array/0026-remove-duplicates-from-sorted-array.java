class Solution {
    public int removeDuplicates(int[] nums) {
        Set<Integer> set = new TreeSet<>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                continue;
            }
            set.add(nums[i]);
        }

        int idx = 0;
        Iterator iter = set.iterator();
        while(iter.hasNext()){
            nums[idx++] = (int) iter.next();
        }
        
        return set.size();
    }
}