class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {		
		Set<Integer> set1 = new HashSet<>(Arrays.stream(nums1)
												.boxed()
												.collect(Collectors.toList()));
		
		Set<Integer> set2 = new HashSet<>(Arrays.stream(nums2)
												.boxed()
												.collect(Collectors.toList()));
		
		List<Integer> list1 = getDifferenceList(nums1, set2);
		List<Integer> list2 = getDifferenceList(nums2, set1);
		
		return List.of(list1, list2);
    }
	
	private List<Integer> getDifferenceList(int[] nums, Set<Integer> set) {
		return Arrays.stream(nums)
				.filter(num -> !set.contains(num))
				.distinct()
				.boxed()
				.collect(Collectors.toList());
	}
}