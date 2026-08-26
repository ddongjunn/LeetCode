class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        String result = "";
        int len = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            int count = 0; // 1의 개수

            for (int j = i; j < s.length(); j++) {  
                if (s.charAt(j) == '1') {
                    count++;
                }

                if (count == k) {
                    String str = s.substring(i, j + 1);

                    if (str.length() < len 
                        || (str.length() == len && str.compareTo(result) < 0)) {
                        len = str.length();
                        result = str;
                    }
                    break;
                }
            }
        }

        return result;
    }
}

/**
k개수 만큼 1인 경우 아름다운 문자
정답은 아름다운 문자중 가장 짧은 문자 

s를 substring으로 자르면서 1의 개수를 먼저 맞추면서
가장 짧은 길이 일때 그 문자를 저장
마지막 결과 return?


1. 1의 개수가 k일때까지 문자열을 하나씩 늘리면서 만들어야한다.
2. 1의 개수가 k라면 그때의 문자를 저장한다. 
    ㄴ저장된 문자와 길이를 비교후 현재 문자가 길이가 더 적은 경우 갱신
3. 그다음 오른쪽을 늘려가면서 1의 개수가 k보다 크다면 k개수일때까지 왼쪽을 줄인다.


left < right로 불가능..
left = 0;
right = 0; 부터 시작해서 right left를 조절해야하는데
while(left < right) 조건 성립이 안된다.
 */