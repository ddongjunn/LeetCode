class Solution {
    public String addBinary(String a, String b) {
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;

        StringBuilder sb = new StringBuilder();
        while (i >= 0 || j >= 0 || carry > 0) {
            int val1 = 0;
            if (i >= 0) {
                val1 = a.charAt(i--) - '0';
            }

            int val2 = 0;
            if (j >= 0) {
                val2 = b.charAt(j--) - '0';
            }

            int sum = val1 + val2 + carry;
            carry = sum / 2;
            sb.append(sum % 2);
        }
        
        return sb.reverse().toString();
    }
}
/**
a, b 두개의 길이만큼 전부 확인해야함
자리올림(carry)를 별도로 계산
    - carry가 있는 경우 2 or 3
        3이면 현재 자리는 1
        2이면 현재 자리는 0
 */