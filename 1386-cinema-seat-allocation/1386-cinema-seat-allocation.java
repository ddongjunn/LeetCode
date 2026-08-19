class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> reservedRows = new HashMap<>();
        for (int[] reservedSeat : reservedSeats) {
            int row = reservedSeat[0];
            int seat = reservedSeat[1];
            reservedRows.computeIfAbsent(row, s -> new HashSet<>()).add(seat);
        }

        int result = (n - reservedRows.size()) * 2;
        for (Set<Integer> seats : reservedRows.values()) {
            boolean isLeft = !(seats.contains(2) || seats.contains(3) || seats.contains(4) || seats.contains(5));
            boolean isRight = !(seats.contains(6) || seats.contains(7) || seats.contains(8) || seats.contains(9));

            if (isLeft) {
                result++;
            }

            if (isRight) {
                result++;
            }

            if (!isLeft && !isRight) {
                if (!(seats.contains(4) || seats.contains(5) || seats.contains(6) || seats.contains(7))) {
                    result++;
                }
            }
        }

        return result;
    }
}