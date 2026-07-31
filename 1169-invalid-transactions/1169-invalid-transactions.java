class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < transactions.length; i++) {
            Transaction tx1 = new Transaction(transactions[i]);

            if (tx1.amount > 1000) {
                if (!set.contains(i)) {
                    ans.add(transactions[i]);
                    set.add(i);
                }
            }

            for (int j = i + 1; j < transactions.length; j++) {
                Transaction tx2 = new Transaction(transactions[j]);

                if (tx2.amount > 1000) {
                    if (!set.contains(j)) {
                        ans.add(transactions[j]);
                        set.add(j);
                    }
                }

                if (tx1.name.equals(tx2.name) && !tx1.city.equals(tx2.city) && Math.abs(tx2.time - tx1.time) <= 60) {
                    if (!set.contains(i)) {
                        ans.add(transactions[i]);
                        set.add(i);
                    }

                    if (!set.contains(j)) {
                        ans.add(transactions[j]);
                        set.add(j);
                    }
                }
            }
        }
        return ans;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;

    Transaction (String info) {
        String[] str = info.split(",");
        this.name = str[0];
        this.time = Integer.parseInt(str[1]);
        this.amount = Integer.parseInt(str[2]);
        this.city = str[3];
    }
}