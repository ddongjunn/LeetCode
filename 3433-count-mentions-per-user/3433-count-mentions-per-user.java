class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort(
            Comparator
                .comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
                .thenComparing(e -> e.get(0).equals("OFFLINE") ? 0 : 1)
        );

        int[] answer = new int[numberOfUsers];
        int[] offline = new int[numberOfUsers];
        
        for (List<String> event : events) {
            String type = event.get(0);
            int timestamp = Integer.parseInt(event.get(1));
            String value = event.get(2);

            if ("OFFLINE".equals(type)) {
                int id = Integer.parseInt(value);
                offline[id] = timestamp + 60;
                continue;
            }

            if ("ALL".equals(value)) {
                for (int i = 0; i < numberOfUsers; i++) {
                    answer[i]++;
                }
                continue;
            }

            if ("HERE".equals(value)) {
                for (int i = 0; i < numberOfUsers; i++) {
                    if (offline[i] <= timestamp) {
                        answer[i]++;
                    }
                }
                continue;
            }

            for (String mention : value.split(" ")) {
                int id = Integer.parseInt(mention.substring(2));
                answer[id]++;
            }
        }

        return answer;
    }
}