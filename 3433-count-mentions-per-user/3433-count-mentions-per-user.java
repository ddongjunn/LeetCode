class Solution {
    public int[] countMentions(int numberOfUsers, List<List<String>> events) {
        events.sort(
            Comparator
                .comparingInt((List<String> e) -> Integer.parseInt(e.get(1)))
                .thenComparing(e -> e.get(0).equals("OFFLINE") ? 0 : 1)
        );

        Map<Integer, Integer> offlineMap = new HashMap<>();
        int[] answer = new int[numberOfUsers];
        
        for (int i = 0; i < events.size(); i++) {
            List<String> event = events.get(i);
        
            String type = event.get(0);
            Integer timestamp = Integer.parseInt(event.get(1));
            String mentions = event.get(2);

            List<Integer> removeIds = new ArrayList();
            offlineMap.forEach((k, v) -> {
                if (v + 60 <= timestamp) {
                    removeIds.add(k);
                }
            });
            removeIds.forEach(j -> offlineMap.remove(j));

            if (("OFFLINE").equals(type)) {
                offlineMap.put(Integer.parseInt(mentions), timestamp);
                continue;
            }

            if (("MESSAGE").equals(type)) {
                if ("ALL".equals(mentions)) {
                    for (int j = 0; j < answer.length; j++){
                        answer[j]++;
                    }
                    continue; 
                }

                Set<Integer> offlineSet = new HashSet();
                if ("HERE".equals(mentions)) {
                    offlineMap.entrySet().forEach(entry -> {
                        offlineSet.add(entry.getKey());
                    });
                    
                    for (int j = 0; j < answer.length; j++) {
                        if (!offlineSet.contains(j)) {
                            answer[j]++;
                        }
                    }
                    continue;
                }

                int[] ids = Arrays.stream(mentions.replace("id","").split(" ")).mapToInt(Integer::parseInt).toArray();

                for (int j = 0; j < ids.length; j++) {
                    answer[ids[j]]++;
                }
            }
        }

        return answer;
    }
}