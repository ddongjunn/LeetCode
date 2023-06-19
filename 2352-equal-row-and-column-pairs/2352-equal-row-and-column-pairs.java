class Solution {
    public int equalPairs(int[][] grid) {
		int n = grid.length;
		int row = 0, temp = 0, ans = 0;
		while(temp < grid.length) {
			Map<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) {
				map.put(i, grid[row][i]);
			}
			
			for(int i=0; i<n; i++) {
				int cur = 0;
				for(int j=0; j<n; j++) {
					if(map.get(j) != grid[j][i]) {
						cur = 0;
						break;
					}
					cur = 1;
				}
				ans += cur;
			}
			temp++;
			row++;
		}
		return ans;
    }
}