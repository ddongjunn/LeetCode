class Solution {
    public List<String> invalidTransactions(String[] transactions) {
        List<String> ans = new ArrayList<>();
        Transaction[] transaction = new Transaction[transactions.length];
        for (int i = 0; i < transactions.length; i++) {
            transaction[i] = new Transaction(transactions[i]);
        }

        for (int i = 0; i < transactions.length; i++) {
            Transaction t = transaction[i];
            if (isInValid(t, transaction, i)) {
                ans.add(transactions[i]);
            }
        }

        return ans;
    }

    public boolean isInValid(Transaction t, Transaction[] txs, int idx) {
        if (t.amount > 1000) {
            return true;
        }

        for (int i = 0; i < txs.length; i++) {
            if (idx != i && (Math.abs(txs[i].time - t.time) <= 60) && (t.name.equals(txs[i].name)) && (!t.city.equals(txs[i].city))) {
                return true;
            }
        }
        return false;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;

    Transaction (String s) {
        String[] ss = s.split(",");
        this.name = ss[0];
        this.time = Integer.parseInt(ss[1]);
        this.amount = Integer.parseInt(ss[2]);
        this.city = ss[3];
    }
}