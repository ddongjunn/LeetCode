class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			List<Boolean> answer = new ArrayList<>();
			
	        int max = Integer.MIN_VALUE;
			for(int i : candies) {
				max = Math.max(i, max);
			}
			
			
			for(int i : candies) {
				if(max <= i + extraCandies) {
					answer.add(true);
				}else {
					answer.add(false);
				}
			}
			
			return answer;
	}
}