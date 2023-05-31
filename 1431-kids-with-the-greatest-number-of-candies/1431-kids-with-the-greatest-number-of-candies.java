class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
			List<Boolean> answer = new ArrayList<>();
			
	        int max = Arrays.stream(candies).max().orElse(0);
	        
	        for(int i : candies) {
	        	int candy = i + extraCandies;
	        	answer.add(candy >= max);
	        }
			
			return answer;
	}
}