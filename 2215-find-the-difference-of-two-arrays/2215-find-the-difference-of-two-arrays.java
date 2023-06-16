class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
		
		Set<Integer> set1 = new HashSet<>();
        for(int i : nums1) {
        	set1.add(i);
        }
        
        Set<Integer> set2 = new HashSet<>();
        for(int i : nums2) {
        	set2.add(i);
        }
        
        List<Integer> list1 = new ArrayList<>();
        for(int i : nums1) {
        	if(!set2.contains(i) && !list1.contains(i)) {
        		list1.add(i);
        	}
        }
        
        List<Integer> list2 = new ArrayList<>();
        for(int i : nums2) {
        	if(!set1.contains(i) && !list2.contains(i)) {
        		list2.add(i);
        	}
        }
        
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        
        return result;
    }
}