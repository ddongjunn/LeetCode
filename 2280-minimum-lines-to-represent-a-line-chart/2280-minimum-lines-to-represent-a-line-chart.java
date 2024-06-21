class Solution {
    public int minimumLines(int[][] stockPrices) {
        Arrays.sort(stockPrices, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        int res = 0;
        int prevX = 0;
        int prevY = 0;
        double inclination = Double.MAX_VALUE;
        for(int i = 0; i < stockPrices.length - 1; i++) {
            int x = stockPrices[i + 1][0] - stockPrices[i][0];
            int y = stockPrices[i + 1][1] - stockPrices[i][1];
            
            int gcd = gcd(x, y);
            x /= gcd;
            y /= gcd;
            
            if(x != prevX || y != prevY) {
                res++;
                prevX = x;
                prevY = y;
            }
        }
        
        return res;
    }
    
    public int gcd(int x, int y) {
        while(y != 0) {
            int tmp = y;
            y = x % y;
            x = tmp;
        }
        return x;
    }
}