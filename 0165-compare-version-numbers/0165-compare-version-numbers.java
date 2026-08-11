class Solution {
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len = Math.max(v1.length, v2.length);

        int i = 0;
        int j = 0;
        while (i < len && j < len) {
            int num1 = 0;
            if (v1.length > i) {
                num1 = Integer.parseInt(v1[i]);
            }

            int num2 = 0;
            if (v2.length > j) {
                num2 = Integer.parseInt(v2[j]);
            }

            if (num1 < num2) {
                return -1;
            } else if (num1 > num2) {
                return 1;
            }
            i++;
            j++;
        }

        return 0;
    }
}


/**
If version1 < version2, return -1.
If version1 > version2, return 1.

앞의 0은 무시한다
둘중 하나 최대값으로 반복문 -> 길이가 짤리는 경우 0으로 채운다.
 */