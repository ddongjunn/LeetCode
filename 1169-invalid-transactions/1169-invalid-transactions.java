class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        // 이름, 시간, 금액, 지역
        // 1. 금액이 1000달러 초과
        // 2. 60분 이내 동일한 이름으로 다른 도시 내역

        boolean[] invalid = new boolean[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            String[] t1 = transactions[i].split(",");
            if (Integer.parseInt(t1[2]) > 1000) {
                invalid[i] = true;
            }

            for (int j = i + 1; j < transactions.length; j++) {
                String[] t2 = transactions[j].split(",");
                int time1 = Integer.parseInt(t1[1]);
                int time2 = Integer.parseInt(t2[1]);
                if (Math.abs(time1 - time2) <= 60 && t1[0].equals(t2[0]) && !t1[3].equals(t2[3]))
                {
                    invalid[i] = true;
                    invalid[j] = true;
                } 
            }
        }

        List<String> ans = new ArrayList<>();
        for (int i = 0; i < invalid.length; i++) {
            if (invalid[i]) {
                ans.add(transactions[i]);
            }
        }

        return ans;
    }
}