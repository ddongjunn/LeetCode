class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> answer = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    answer.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }

        List<String> answer2 = new ArrayList<>();
        for (int n = 0; n < 1024; n++) {
            if (Integer.bitCount(n) == turnedOn) {
                int hour = n >> 6;
                int minute = n & 63;
                if (hour < 12 && minute < 60) {
                    answer2.add(hour + ":" + (minute < 10 ? "0" + minute : minute));
                }
            }
        }
        return answer2;
    }
}