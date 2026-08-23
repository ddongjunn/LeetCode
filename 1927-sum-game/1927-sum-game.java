class Solution {
    public boolean sumGame(String num) {
        int half = num.length() / 2;

        int leftSum = 0;
        int rightSum = 0;
        int leftQuestion = 0;
        int rightQuestion = 0;

        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);

            if (i < half) {
                if (ch == '?') {
                    leftQuestion++;
                } else {
                    leftSum += ch - '0';
                }
            } else {
                if (ch == '?') {
                    rightQuestion++;
                } else {
                    rightSum += ch - '0';
                }
            }
        }

        int sumDiff = leftSum - rightSum;
        int questionDiff = rightQuestion - leftQuestion;
        return sumDiff * 2 != questionDiff * 9;
    }
}


/*
Alice:
최종적으로 왼쪽 절반의 합 != 오른쪽 절반의 합

Bob:
최종적으로 왼쪽 절반의 합 == 오른쪽 절반의 합

Alice가 x를 입력하면 Bob은 9 - x를 입력해서 합을 9로 만들 수 있다.
x + (9 - x) = 9

? 2개를 한쌍으로 보면, ? 2개당 9
(rightQuestion - leftQuestion) / 2 * 9 

(leftSum - rightSum) * 2 == (rightQuestion - leftQuestion) * 9
sumDiff가 양수이면 왼쪽 합이 더 크다. 
Bob이 합을 같게 만들려면 오른쪽이 그 차이를 메워야 하므로,
?의 차이는 rightQuestion - leftQuesion 방향
*/