class Solution {
    public boolean closeStrings(String word1, String word2) {
    if (word1.length() != word2.length()) {
        return false;
    }

    Map<Character, Integer> map1 = buildCharacterFrequencyMap(word1);
    Map<Character, Integer> map2 = buildCharacterFrequencyMap(word2);

    if (!map1.keySet().equals(map2.keySet())) {
        return false;
    }

    List<Integer> frequencies1 = new ArrayList<>(map1.values());
    List<Integer> frequencies2 = new ArrayList<>(map2.values());

    Collections.sort(frequencies1);
    Collections.sort(frequencies2);

    return frequencies1.equals(frequencies2);
}

private Map<Character, Integer> buildCharacterFrequencyMap(String word) {
    Map<Character, Integer> frequencyMap = new HashMap<>();
    for (char ch : word.toCharArray()) {
        frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
    }
    return frequencyMap;
}
}