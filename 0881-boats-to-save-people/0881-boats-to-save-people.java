class Solution {
    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);

        int left = 0;
        int right = people.length -1;
        int answer = 0;
        boolean carry = false;

        while (left <= right) {
            int l = people[left];
            int r = people[right];

            if (l + r > limit) {
                answer++;
                right--;
            } else if (l + r == limit || l + r < limit) {
                answer++;
                right--;
                left++;
            } else {
                answer++;
                left++;
            }
        }
        return answer; 
    }
}