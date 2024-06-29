class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        Map<Character, Integer> freqs = new HashMap();
        for(char stone : stones.toCharArray()) {
            freqs.put(stone, freqs.getOrDefault(stone, 0) +1);
        }
        
        int ans = 0;
        for(char jewel : jewels.toCharArray()) {
            if(freqs.containsKey(jewel)){
                ans += freqs.get(jewel);    
            }
        }
        
        return ans;
    }
}